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

    public static int currentScore = 0;

    public static NMSBoard board = null;

    public static String craftName = null;

    public static Material requiredItem = null;

    public static List<NMSEntities> frames = new ArrayList<>();

    private static Villager foreman = null;

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
                    board = new NMSBoard(p, "§6Workshop");
                    board.set(p,15, "§e§m--------------------");
                    board.set(p, 14, " ");
                    board.set(p, 13, "Craft: §e"+craftName);
                    board.set(p, 12, "  ");
                    board.set(p, 11, "Progress: §a"+currentScore+"/"+Main.maxScore);
                    board.set(p, 10, "   ");
                    board.set(p, 8, "Time: §b"+Utils.ROUND.format(((float) Duration.between(Core.gameBegin, Instant.now()).toMillis() / 1000.0f))+"s");
                    board.set(p, 7, "    ");
                    board.set(p,6, "§e§m-------------------- ");
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Main.gameSpawn);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 60L);
    }

    public static void update() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (board != null) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        board.set(p, 8, "Time: §b" + Utils.ROUND.format(((float) Duration.between(Core.gameBegin, Instant.now()).toMillis() / 1000.0f)) + "s");
                    }
                }
            }
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
    }

    public static void end() {
        gameEnd = Instant.now();
        foreman.remove();
        for (NMSEntities e : frames) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                NMSEntityDestroy.send(p, e.getID());
            }
        }
        frames.clear();

        Main.gameRunning = false;
        Utils.cleanWorkshop();
        for (Player p : Bukkit.getOnlinePlayers()) {
            board.clear(p);
            board = null;
            p.sendMessage("§aYou completed "+currentScore+" craft in: §b"+Utils.ROUND.format(((float) Duration.between(Core.gameBegin, Core.gameEnd).toMillis() / 1000.0f))+"s");
            p.getInventory().clear();
            p.teleport(Main.spawn);
        }
    }
}
