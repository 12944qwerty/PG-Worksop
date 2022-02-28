package com.blackoutburst.pgworkshop.utils;

import com.blackoutburst.pgworkshop.core.Core;
import com.blackoutburst.pgworkshop.core.CraftEnum;
import com.blackoutburst.pgworkshop.core.ResourcesEnum;
import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.nms.NMSEntities;
import com.blackoutburst.pgworkshop.nms.NMSItemFrame;
import com.blackoutburst.pgworkshop.nms.NMSTitle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    public static void chooseCraft() {
        final int rng = RANDOM.nextInt(CraftEnum.values().length);

        Core.requiredItem = CraftEnum.values()[rng].item;

        for (int i = 0; i < Core.frames.size() - 1; i++) {
            final NMSEntities frame = Core.frames.get(i);
            final Material material = CraftEnum.values()[rng].mats[i];
            final ItemStack stack = new ItemStack(material, 1, (byte) (material.equals(Material.INK_SACK) ? 4 : 0));

            for (Player player : Bukkit.getOnlinePlayers()) {
                NMSItemFrame.setItem(player, frame, stack);
            }
        }

        final NMSEntities frame = Core.frames.get(Core.frames.size() - 1);
        final Material material = CraftEnum.values()[rng].item;
        final ItemStack stack = new ItemStack(material, 1, (byte) 0);

        for (Player player : Bukkit.getOnlinePlayers()) {
            NMSItemFrame.setItem(player, frame, stack);
        }
        generateRessrouces(CraftEnum.values()[rng]);

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

    private static void removeUnwantedMaterial(List<Location> locs) {
        for (Location l : locs) {
            if (!Core.requiredItem.equals(Material.ENCHANTMENT_TABLE)) {
                if (Main.world.getBlockAt(l).getType().equals(Material.BOOKSHELF)) {
                    int rng = RANDOM.nextInt(ResourcesEnum.values().length - 5);
                    l.getWorld().getBlockAt(l).setType(ResourcesEnum.values()[rng].block);
                    l.getWorld().getBlockAt(l).setData(ResourcesEnum.values()[rng].blockData);
                }
            }
            if (!Core.requiredItem.equals(Material.LAPIS_BLOCK)) {
                if (Main.world.getBlockAt(l).getType().equals(Material.LAPIS_ORE)) {
                    int rng = RANDOM.nextInt(ResourcesEnum.values().length - 5);
                    l.getWorld().getBlockAt(l).setType(ResourcesEnum.values()[rng].block);
                    l.getWorld().getBlockAt(l).setData(ResourcesEnum.values()[rng].blockData);
                }
            }
            if (!Core.requiredItem.equals(Material.EMERALD_BLOCK)) {
                if (Main.world.getBlockAt(l).getType().equals(Material.EMERALD_ORE)) {
                    int rng = RANDOM.nextInt(ResourcesEnum.values().length - 5);
                    l.getWorld().getBlockAt(l).setType(ResourcesEnum.values()[rng].block);
                    l.getWorld().getBlockAt(l).setData(ResourcesEnum.values()[rng].blockData);
                }
            }
            if (!Core.requiredItem.equals(Material.ARMOR_STAND)) {
                if (Main.world.getBlockAt(l).getType().equals(Material.STEP)) {
                    int rng = RANDOM.nextInt(ResourcesEnum.values().length - 5);
                    l.getWorld().getBlockAt(l).setType(ResourcesEnum.values()[rng].block);
                    l.getWorld().getBlockAt(l).setData(ResourcesEnum.values()[rng].blockData);
                }
            }
        }
    }

    private static void placeRessources(List<Location> locs) {
        for (Location l : locs) {
            int rng = RANDOM.nextInt(ResourcesEnum.values().length);
            Material mat = ResourcesEnum.values()[rng].block;
            byte data = ResourcesEnum.values()[rng].blockData;

            l.getWorld().getBlockAt(l).setType(mat);
            l.getWorld().getBlockAt(l).setData(data);
        }
    }

    public static void generateRessrouces(CraftEnum craft) {
        placeRessources(Main.priorityMaterials);
        removeUnwantedMaterial(Main.priorityMaterials);

        final List<Location> priorityLocation = new ArrayList<>(Main.priorityMaterials);

        for (Material mat : craft.mats) {
            if (mat.equals(Material.AIR)) continue;
            final Location l = priorityLocation.get(RANDOM.nextInt(priorityLocation.size()));

            String matName = "STONE";

            switch (mat) {
                case COAL: matName = "COAL_ORE"; break;
                case WOOD: matName = "LOG"; break;
                case STICK: matName = "LOG"; break;
                case COBBLESTONE: matName = RANDOM.nextInt(2) == 0 ? "STONE" : "GRANITE"; break;
                case IRON_INGOT: matName = "IRON_ORE"; break;
                case GOLD_INGOT: matName = "GOLD_ORE"; break;
                case REDSTONE: matName = "REDSTONE_ORE"; break;
                case DIAMOND: matName = "DIAMOND_ORE"; break;
                case STRING: matName = "COBWEB"; break;
                case BOOK: matName = "BOOKSHELF"; break;
                case INK_SACK: matName = "LAPIS_ORE"; break;
                case EMERALD: matName = "EMERALD_ORE"; break;
                case STEP: matName = RANDOM.nextInt(2) == 0 ? "SANDSTONE_SLAB" : "STONE_SLAB"; break;
            }

            l.getWorld().getBlockAt(l).setType(ResourcesEnum.valueOf(matName).block);
            l.getWorld().getBlockAt(l).setData(ResourcesEnum.valueOf(matName).blockData);
            priorityLocation.remove(l);
        }

        placeRessources(Main.materials);
        removeUnwantedMaterial(Main.materials);
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
