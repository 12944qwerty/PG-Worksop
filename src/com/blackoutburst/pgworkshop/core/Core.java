package com.blackoutburst.pgworkshop.core;

import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.nms.*;
import com.blackoutburst.pgworkshop.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Core {

    public static Instant craftBegin;
    public static Instant craftEnd;

    public static Instant gameBegin;
    public static Instant gameEnd;

    public static int currentScore;

    public static Material requiredItem = null;
    public static List<NMSEntities> frames = new ArrayList<>();
    private static Villager foreman;

    private static void placeItemFrame() {
        for (Location l : Main.itemFrames) {
            Main.world.getBlockAt(l).setType(Material.AIR);
            NMSBlockPosition position = new NMSBlockPosition(l.getBlockX(), l.getBlockY(), l.getBlockZ());
            NMSEnumDirection direction = new NMSEnumDirection(NMSEnumDirection.Direction.NORTH);
            NMSEntities itemFrame = new NMSEntities(Main.world, NMSEntities.EntityType.ITEM_FRAME, position.position, direction.direction);
            frames.add(itemFrame);

            for (Player p : Bukkit.getOnlinePlayers()) {
                NMSSpawnEntity.send(p, itemFrame);
            }
        }
    }

    public static void start() {
        currentScore = 0;
        gameBegin = Instant.now();
        Main.world.getBlockAt(Main.gameSpawn).setType(Material.AIR);
        placeItemFrame();

        foreman = Main.world.spawn(Main.foremanLocation, Villager.class);
        foreman.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 255, false, false));

        Utils.countdown();
        new BukkitRunnable() {
            @Override
            public void run() {
                Main.gameRunning = true;
                Main.world.setDifficulty(Difficulty.PEACEFUL);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Utils.chooseCraft(p);
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Main.gameSpawn);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 60L);
    }

    public static void end() {
        gameEnd = Instant.now();
        foreman.remove();
        for (NMSEntities e : frames) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage("§aYou completed "+currentScore+" craft in: §b"+Utils.ROUND.format((Float.valueOf(Duration.between(Core.gameBegin, Core.gameEnd).toMillis()) / 1000.0f))+"s");
                NMSEntityDestroy.send(p, e.getID());
            }
        }
        frames.clear();

        Main.gameRunning = false;
        Utils.cleanWorkshop();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.getInventory().clear();
            p.teleport(Main.spawn);
        }
    }
}
