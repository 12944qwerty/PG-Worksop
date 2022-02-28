package com.blackoutburst.pgworkshop.core;

import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.nms.*;
import com.blackoutburst.pgworkshop.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Core {

    public static Material requiredItem = null;
    public static List<NMSEntities> frames = new ArrayList<>();
    public static int foremanID;

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
        Main.world.getBlockAt(Main.gameSpawn).setType(Material.AIR);
        placeItemFrame();

        NMSEntities foreman = new NMSEntities(Main.world, NMSEntities.EntityType.VILLAGER);
        for (Player p : Bukkit.getOnlinePlayers()) {
            NMSSpawnEntityLiving.send(p, foreman);
            NMSEntityTeleport.send(p, foreman, Main.foremanLocation.getX(), Main.foremanLocation.getY(), Main.foremanLocation.getZ());
            new BukkitRunnable() {
                @Override
                public void run() {
                    NMSEntityHeadRotation.send(p, foreman, 180);
                }
            }.runTaskLater(Main.getPlugin(Main.class), 5L);
        }
        foremanID = foreman.getID();


        Utils.countdown();
        new BukkitRunnable() {
            @Override
            public void run() {
                Main.gameRunning = true;
                Main.world.setDifficulty(Difficulty.PEACEFUL);
                Utils.chooseCraft();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Main.gameSpawn);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 60L);
    }

    public static void end() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            NMSEntityDestroy.send(p, foremanID);
        }
        for (NMSEntities e : frames) {
            for (Player p : Bukkit.getOnlinePlayers()) {
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
