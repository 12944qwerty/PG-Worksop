package com.blackoutburst.pgworkshop.core;

import org.bukkit.Material;

/**
 * This will be used to display stuff inside the item frame
 */
public enum CraftEnum {

    WOODEN_BUTTON(Material.WOOD_BUTTON,
            Material.WOOD, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    WORKBENCH(Material.WORKBENCH,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    BOAT(Material.BOAT,
            Material.WOOD, Material.AIR, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.AIR, Material.AIR, Material.AIR),

    WOODEN_PRESSURE_PLATE(Material.WOOD_PLATE,
         Material.WOOD, Material.WOOD, Material.AIR,
         Material.AIR, Material.AIR, Material.AIR,
         Material.AIR, Material.AIR, Material.AIR),

    ARMOR_STAND(Material.ARMOR_STAND,
            Material.STICK, Material.STICK, Material.STICK,
            Material.AIR, Material.STICK, Material.AIR,
            Material.STICK, Material.STEP, Material.STICK),

    FURNACE(Material.FURNACE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE,
            Material.COBBLESTONE, Material.AIR, Material.COBBLESTONE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE),

    FENCE(Material.FENCE,
            Material.WOOD, Material.STICK, Material.WOOD,
            Material.WOOD, Material.STICK, Material.WOOD,
            Material.AIR, Material.AIR, Material.AIR),

    FENCE_GATE(Material.FENCE_GATE,
            Material.STICK, Material.WOOD, Material.STICK,
            Material.STICK, Material.WOOD, Material.STICK,
            Material.AIR, Material.AIR, Material.AIR),

    WOODEN_PICKAXE(Material.WOOD_PICKAXE,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    WOODEN_AXE(Material.WOOD_AXE,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.WOOD, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    WOODEN_HOE(Material.WOOD_HOE,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    WOODEN_SWORD(Material.WOOD_SWORD,
            Material.AIR, Material.WOOD, Material.AIR,
            Material.AIR, Material.WOOD, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_PICKAXE(Material.STONE_PICKAXE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_AXE(Material.STONE_AXE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.AIR,
            Material.COBBLESTONE, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_HOE(Material.STONE_HOE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_SWORD(Material.STONE_SWORD,
            Material.AIR, Material.COBBLESTONE, Material.AIR,
            Material.AIR, Material.COBBLESTONE, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_PICKAXE(Material.IRON_PICKAXE,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_AXE(Material.IRON_AXE,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.AIR,
            Material.IRON_INGOT, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_HOE(Material.IRON_HOE,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_SWORD(Material.IRON_SWORD,
            Material.AIR, Material.IRON_INGOT, Material.AIR,
            Material.AIR, Material.IRON_INGOT, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_PICKAXE(Material.GOLD_PICKAXE,
                 Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
                 Material.AIR, Material.STICK, Material.AIR,
                 Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_AXE(Material.GOLD_AXE,
             Material.GOLD_INGOT, Material.GOLD_INGOT, Material.AIR,
             Material.GOLD_INGOT, Material.STICK, Material.AIR,
             Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_HOE(Material.GOLD_HOE,
             Material.GOLD_INGOT, Material.GOLD_INGOT, Material.AIR,
             Material.AIR, Material.STICK, Material.AIR,
             Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_SWORD(Material.GOLD_SWORD,
               Material.AIR, Material.GOLD_INGOT, Material.AIR,
               Material.AIR, Material.GOLD_INGOT, Material.AIR,
               Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_AXE(Material.DIAMOND_AXE,
            Material.DIAMOND, Material.DIAMOND, Material.AIR,
            Material.DIAMOND, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_HOE(Material.DIAMOND_HOE,
            Material.DIAMOND, Material.DIAMOND, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_SWORD(Material.DIAMOND_SWORD,
            Material.AIR, Material.DIAMOND, Material.AIR,
            Material.AIR, Material.DIAMOND, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    ENCHANTMENT_TABLE(Material.ENCHANTMENT_TABLE,
            Material.AIR, Material.BOOK, Material.AIR,
            Material.DIAMOND, Material.OBSIDIAN, Material.DIAMOND,
            Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN),

    COAL_BLOCK(Material.COAL_BLOCK,
                      Material.COAL, Material.COAL, Material.COAL,
                      Material.COAL, Material.COAL, Material.COAL,
                      Material.COAL, Material.COAL, Material.COAL),

    LAPIS_BLOCK(Material.LAPIS_BLOCK,
            Material.INK_SACK, Material.INK_SACK, Material.INK_SACK,
            Material.INK_SACK, Material.INK_SACK, Material.INK_SACK,
            Material.INK_SACK, Material.INK_SACK, Material.INK_SACK),

    IRON_BLOCK(Material.IRON_BLOCK,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT),

    GOLD_BLOCK(Material.GOLD_BLOCK,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT),

    DIAMOND_BLOCK(Material.DIAMOND_BLOCK,
               Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
               Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
               Material.DIAMOND, Material.DIAMOND, Material.DIAMOND),

    EMERALD_BLOCK(Material.EMERALD_BLOCK,
            Material.EMERALD, Material.EMERALD, Material.EMERALD,
            Material.EMERALD, Material.EMERALD, Material.EMERALD,
            Material.EMERALD, Material.EMERALD, Material.EMERALD),

    REDSTONE_BLOCK(Material.REDSTONE_BLOCK,
            Material.REDSTONE, Material.REDSTONE, Material.REDSTONE,
            Material.REDSTONE, Material.REDSTONE, Material.REDSTONE,
            Material.REDSTONE, Material.REDSTONE, Material.REDSTONE),

    TORCH(Material.TORCH,
            Material.COAL, Material.AIR, Material.AIR,
            Material.STICK, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    IRON_HELMET(Material.IRON_HELMET,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    IRON_CHESTPLATE(Material.IRON_CHESTPLATE,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT),

    IRON_LEGGINGS(Material.IRON_LEGGINGS,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT),

    IRON_BOOTS(Material.IRON_BOOTS,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    GOLDEN_HELMET(Material.GOLD_HELMET,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    GOLDEN_CHESTPLATE(Material.GOLD_CHESTPLATE,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT),

    GOLDEN_LEGGINGS(Material.GOLD_LEGGINGS,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT),

    GOLDEN_BOOTS(Material.GOLD_BOOTS,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    DIAMOND_HELMET(Material.DIAMOND_HELMET,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.AIR, Material.AIR, Material.AIR),

    DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND),

    DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND),

    DIAMOND_BOOTS(Material.DIAMOND_BOOTS,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.AIR, Material.AIR, Material.AIR),

    CAULDRON(Material.CAULDRON_ITEM,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT),

    PISTON(Material.PISTON_BASE,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.COBBLESTONE, Material.IRON_INGOT, Material.COBBLESTONE,
            Material.COBBLESTONE, Material.REDSTONE, Material.COBBLESTONE),

    RAIL(Material.RAILS,
           Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
           Material.IRON_INGOT, Material.STICK, Material.IRON_INGOT,
           Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT),

    MINECART(Material.MINECART,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    SIGN(Material.SIGN,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.AIR, Material.STICK, Material.AIR),

    FISHING_ROD(Material.FISHING_ROD,
            Material.AIR, Material.AIR, Material.STICK,
            Material.AIR, Material.STICK, Material.STRING,
            Material.STICK, Material.AIR, Material.STRING),

    BOW(Material.BOW,
            Material.STRING, Material.STICK, Material.AIR,
            Material.STRING, Material.AIR, Material.STICK,
            Material.STRING, Material.STICK, Material.AIR),

    CHEST(Material.CHEST,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.WOOD, Material.AIR, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD),

    NOTE_BLOCK(Material.NOTE_BLOCK,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.WOOD, Material.REDSTONE, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD),

    COMPASS(Material.COMPASS,
            Material.AIR, Material.IRON_INGOT, Material.AIR,
            Material.IRON_INGOT, Material.REDSTONE, Material.IRON_INGOT,
            Material.AIR, Material.IRON_INGOT, Material.AIR);

    public Material item;
    public Material[] mats;


    CraftEnum(Material item, Material... mats) {
        this.item = item;
        this.mats = mats;
    }
}
