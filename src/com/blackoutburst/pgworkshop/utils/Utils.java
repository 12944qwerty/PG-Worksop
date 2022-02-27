package com.blackoutburst.pgworkshop.utils;

import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.nms.NMSTitle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Utils {

    public static void cleanWorkshop() {
        for (Location l : Main.priorityMaterials) {
            l.getWorld().getBlockAt(l).setType(Material.AIR);
        }
        for (Location l : Main.materials) {
            l.getWorld().getBlockAt(l).setType(Material.AIR);
        }
    }

    public static void countdown() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            NMSTitle.send(p.getPlayer(), "§e3", "", 0, 30, 0);
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    NMSTitle.send(p.getPlayer(), "§62", "", 0, 30, 0);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 20L);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    NMSTitle.send(p.getPlayer(), "§c1", "", 0, 20, 0);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 40L);
    }
}
