package com.blackoutburst.pgworkshop.utils;

import com.blackoutburst.pgworkshop.core.Core;
import com.blackoutburst.pgworkshop.core.CraftEnum;
import com.blackoutburst.pgworkshop.core.ResourcesEnum;
import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.nms.NMSTitle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    public static void chooseCraft() {
        final int rng = RANDOM.nextInt(CraftEnum.values().length);

        Core.requiredItem = CraftEnum.values()[rng].item;
    }

    public static void playBreakSound(Material material, Location location) {
        for (ResourcesEnum res : ResourcesEnum.values()) {
            if (res.block.equals(material)) {
                Main.world.playSound(location, res.breakSound, 3, 1);
                break;
            }
        }
    }

    public static ItemStack getDrop(Material material) {
        Material mat = null;
        byte data = 0;

        for (ResourcesEnum res : ResourcesEnum.values()) {
            if (res.block.equals(material)) {
                mat = res.drop;
                data = res.dropData;
                break;
            }
        }
        return (new ItemStack(mat, 1, data));
    }

    public static boolean isMaterial(Location loc) {
        for (Location l : Main.priorityMaterials) {
            if (l.getBlockX() == loc.getBlockX() &&
                l.getBlockY() == loc.getBlockY() &&
                l.getBlockZ() == loc.getBlockZ())
                return (true);
        }

        for (Location l : Main.materials) {
            if (l.getBlockX() == loc.getBlockX() &&
                l.getBlockY() == loc.getBlockY() &&
                l.getBlockZ() == loc.getBlockZ())
                return (true);
        }
        return (false);
    }

    public static void generateRessrouces() {
        for (Location l : Main.priorityMaterials) {
            final int rng = RANDOM.nextInt(ResourcesEnum.values().length);
            final Material mat = ResourcesEnum.values()[rng].block;
            final byte data = ResourcesEnum.values()[rng].blockData;

            l.getWorld().getBlockAt(l).setType(mat);
            l.getWorld().getBlockAt(l).setData(data);
        }
        for (Location l : Main.materials) {
            final int rng = RANDOM.nextInt(ResourcesEnum.values().length);
            final Material mat = ResourcesEnum.values()[rng].block;
            final byte data = ResourcesEnum.values()[rng].blockData;

            l.getWorld().getBlockAt(l).setType(mat);
            l.getWorld().getBlockAt(l).setData(data);
        }
    }

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
