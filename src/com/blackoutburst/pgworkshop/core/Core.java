package com.blackoutburst.pgworkshop.core;

import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.nms.NMSBlockPosition;
import com.blackoutburst.pgworkshop.nms.NMSEntities;
import com.blackoutburst.pgworkshop.nms.NMSEnumDirection;
import com.blackoutburst.pgworkshop.nms.NMSSpawnEntity;
import com.blackoutburst.pgworkshop.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Core {

    public static Material requiredItem = null;
    public static List<NMSEntities> frames = new ArrayList<>();

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

        Main.gameRunning = true;
        Utils.countdown();
        new BukkitRunnable() {
            @Override
            public void run() {
                Main.world.setDifficulty(Difficulty.PEACEFUL);
                Utils.chooseCraft();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Utils.generateRessrouces();
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Main.gameSpawn);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 60L);
    }

    public static void end() {
        Main.gameRunning = false;
        Utils.cleanWorkshop();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.getInventory().clear();
            p.teleport(Main.spawn);
        }
    }
}
