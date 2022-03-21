package com.blackoutburst.pgworkshop.core;

import org.bukkit.Material;

/**
 * This will be used to display stuff inside the item frame
 */
public enum CraftEnum {

    WOODEN_BUTTON("Wooden button", Material.WOOD_BUTTON,
            Material.WOOD, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    WORKBENCH("Crafting table", Material.WORKBENCH,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    BOAT("Boat", Material.BOAT,
            Material.WOOD, Material.AIR, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.AIR, Material.AIR, Material.AIR),

    WOODEN_PRESSURE_PLATE("Wooden pressure plate", Material.WOOD_PLATE,
         Material.WOOD, Material.WOOD, Material.AIR,
         Material.AIR, Material.AIR, Material.AIR,
         Material.AIR, Material.AIR, Material.AIR),

    ARMOR_STAND("Armor stand", Material.ARMOR_STAND,
            Material.STICK, Material.STICK, Material.STICK,
            Material.AIR, Material.STICK, Material.AIR,
            Material.STICK, Material.STEP, Material.STICK),

    FURNACE("Furnace", Material.FURNACE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE,
            Material.COBBLESTONE, Material.AIR, Material.COBBLESTONE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE),

    FENCE("Fence", Material.FENCE,
            Material.WOOD, Material.STICK, Material.WOOD,
            Material.WOOD, Material.STICK, Material.WOOD,
            Material.AIR, Material.AIR, Material.AIR),

    FENCE_GATE("Fence gate", Material.FENCE_GATE,
            Material.STICK, Material.WOOD, Material.STICK,
            Material.STICK, Material.WOOD, Material.STICK,
            Material.AIR, Material.AIR, Material.AIR),

    WOODEN_PICKAXE("Wooden pickaxe", Material.WOOD_PICKAXE,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    WOODEN_AXE("Wooden axe", Material.WOOD_AXE,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.WOOD, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    WOODEN_HOE("Wooden hoe", Material.WOOD_HOE,
            Material.WOOD, Material.WOOD, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    WOODEN_SWORD("Wooden sword", Material.WOOD_SWORD,
            Material.AIR, Material.WOOD, Material.AIR,
            Material.AIR, Material.WOOD, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_PICKAXE("Stone pickaxe", Material.STONE_PICKAXE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_AXE("Stone axe", Material.STONE_AXE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.AIR,
            Material.COBBLESTONE, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_HOE("Stone hoe", Material.STONE_HOE,
            Material.COBBLESTONE, Material.COBBLESTONE, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    STONE_SWORD("Stone sword", Material.STONE_SWORD,
            Material.AIR, Material.COBBLESTONE, Material.AIR,
            Material.AIR, Material.COBBLESTONE, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_PICKAXE("Iron pickaxe", Material.IRON_PICKAXE,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_AXE("Iron axe", Material.IRON_AXE,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.AIR,
            Material.IRON_INGOT, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_HOE("Iron hoe", Material.IRON_HOE,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    IRON_SWORD("Iron sword", Material.IRON_SWORD,
            Material.AIR, Material.IRON_INGOT, Material.AIR,
            Material.AIR, Material.IRON_INGOT, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_PICKAXE("Golden pickaxe", Material.GOLD_PICKAXE,
                 Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
                 Material.AIR, Material.STICK, Material.AIR,
                 Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_AXE("Golden axe", Material.GOLD_AXE,
             Material.GOLD_INGOT, Material.GOLD_INGOT, Material.AIR,
             Material.GOLD_INGOT, Material.STICK, Material.AIR,
             Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_HOE("Golden hoe", Material.GOLD_HOE,
             Material.GOLD_INGOT, Material.GOLD_INGOT, Material.AIR,
             Material.AIR, Material.STICK, Material.AIR,
             Material.AIR, Material.STICK, Material.AIR),

    GOLDEN_SWORD("Golden sword", Material.GOLD_SWORD,
               Material.AIR, Material.GOLD_INGOT, Material.AIR,
               Material.AIR, Material.GOLD_INGOT, Material.AIR,
               Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_PICKAXE("Diamond pickaxe", Material.DIAMOND_PICKAXE,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_AXE("Diamond axe", Material.DIAMOND_AXE,
            Material.DIAMOND, Material.DIAMOND, Material.AIR,
            Material.DIAMOND, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_HOE("Diamond hoe", Material.DIAMOND_HOE,
            Material.DIAMOND, Material.DIAMOND, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    DIAMOND_SWORD("Diamond sword", Material.DIAMOND_SWORD,
            Material.AIR, Material.DIAMOND, Material.AIR,
            Material.AIR, Material.DIAMOND, Material.AIR,
            Material.AIR, Material.STICK, Material.AIR),

    ENCHANTMENT_TABLE("Enchantment table", Material.ENCHANTMENT_TABLE,
            Material.AIR, Material.BOOK, Material.AIR,
            Material.DIAMOND, Material.OBSIDIAN, Material.DIAMOND,
            Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN),

    COAL_BLOCK("Coal block", Material.COAL_BLOCK,
                      Material.COAL, Material.COAL, Material.COAL,
                      Material.COAL, Material.COAL, Material.COAL,
                      Material.COAL, Material.COAL, Material.COAL),

    LAPIS_BLOCK("Lapis block", Material.LAPIS_BLOCK,
            Material.INK_SACK, Material.INK_SACK, Material.INK_SACK,
            Material.INK_SACK, Material.INK_SACK, Material.INK_SACK,
            Material.INK_SACK, Material.INK_SACK, Material.INK_SACK),

    IRON_BLOCK("Iron block", Material.IRON_BLOCK,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT),

    GOLD_BLOCK("Gold block", Material.GOLD_BLOCK,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT),

    DIAMOND_BLOCK("Diamond block", Material.DIAMOND_BLOCK,
               Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
               Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
               Material.DIAMOND, Material.DIAMOND, Material.DIAMOND),

    EMERALD_BLOCK("Emerald block", Material.EMERALD_BLOCK,
            Material.EMERALD, Material.EMERALD, Material.EMERALD,
            Material.EMERALD, Material.EMERALD, Material.EMERALD,
            Material.EMERALD, Material.EMERALD, Material.EMERALD),

    REDSTONE_BLOCK("Redstone block", Material.REDSTONE_BLOCK,
            Material.REDSTONE, Material.REDSTONE, Material.REDSTONE,
            Material.REDSTONE, Material.REDSTONE, Material.REDSTONE,
            Material.REDSTONE, Material.REDSTONE, Material.REDSTONE),

    TORCH("Torch", Material.TORCH,
            Material.COAL, Material.AIR, Material.AIR,
            Material.STICK, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    IRON_HELMET("Iron helmet", Material.IRON_HELMET,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    IRON_CHESTPLATE("Iron chestplate", Material.IRON_CHESTPLATE,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT),

    IRON_LEGGINGS("Iron leggings", Material.IRON_LEGGINGS,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT),

    IRON_BOOTS("Iron boots", Material.IRON_BOOTS,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    GOLDEN_HELMET("Golden helmet", Material.GOLD_HELMET,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    GOLDEN_CHESTPLATE("Golden chestplate", Material.GOLD_CHESTPLATE,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT),

    GOLDEN_LEGGINGS("Golden leggings", Material.GOLD_LEGGINGS,
            Material.GOLD_INGOT, Material.GOLD_INGOT, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT),

    GOLDEN_BOOTS("Golden boots", Material.GOLD_BOOTS,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.GOLD_INGOT, Material.AIR, Material.GOLD_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    DIAMOND_HELMET("Diamond Helmet", Material.DIAMOND_HELMET,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.AIR, Material.AIR, Material.AIR),

    DIAMOND_CHESTPLATE("Diamond chestplate", Material.DIAMOND_CHESTPLATE,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND),

    DIAMOND_LEGGINGS("Diamond leggings", Material.DIAMOND_LEGGINGS,
            Material.DIAMOND, Material.DIAMOND, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND),

    DIAMOND_BOOTS("Diamond boots", Material.DIAMOND_BOOTS,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.DIAMOND, Material.AIR, Material.DIAMOND,
            Material.AIR, Material.AIR, Material.AIR),

    CAULDRON("Cauldron", Material.CAULDRON_ITEM,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT),

    PISTON("Piston", Material.PISTON_BASE,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.COBBLESTONE, Material.IRON_INGOT, Material.COBBLESTONE,
            Material.COBBLESTONE, Material.REDSTONE, Material.COBBLESTONE),

    RAIL("Rails", Material.RAILS,
           Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
           Material.IRON_INGOT, Material.STICK, Material.IRON_INGOT,
           Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT),

    MINECART("Minecart", Material.MINECART,
            Material.IRON_INGOT, Material.AIR, Material.IRON_INGOT,
            Material.IRON_INGOT, Material.IRON_INGOT, Material.IRON_INGOT,
            Material.AIR, Material.AIR, Material.AIR),

    SIGN("Sign", Material.SIGN,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.AIR, Material.STICK, Material.AIR),

    FISHING_ROD("Fishing rod", Material.FISHING_ROD,
            Material.AIR, Material.AIR, Material.STICK,
            Material.AIR, Material.STICK, Material.STRING,
            Material.STICK, Material.AIR, Material.STRING),

    BOW("Bow", Material.BOW,
            Material.STRING, Material.STICK, Material.AIR,
            Material.STRING, Material.AIR, Material.STICK,
            Material.STRING, Material.STICK, Material.AIR),

    CHEST("Chest", Material.CHEST,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.WOOD, Material.AIR, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD),

    NOTE_BLOCK("Noteblock", Material.NOTE_BLOCK,
            Material.WOOD, Material.WOOD, Material.WOOD,
            Material.WOOD, Material.REDSTONE, Material.WOOD,
            Material.WOOD, Material.WOOD, Material.WOOD),

    REDSTONE_TORCH("Redstone torch", Material.REDSTONE_TORCH_ON,
            Material.REDSTONE, Material.AIR, Material.AIR,
            Material.STICK, Material.AIR, Material.AIR,
            Material.AIR, Material.AIR, Material.AIR),

    COMPASS("Compass", Material.COMPASS,
            Material.AIR, Material.IRON_INGOT, Material.AIR,
            Material.IRON_INGOT, Material.REDSTONE, Material.IRON_INGOT,
            Material.AIR, Material.IRON_INGOT, Material.AIR);

    public final String name;
    public final Material item;
    public final Material[] mats;

    CraftEnum(String name, Material item, Material... mats) {
        this.name = name;
        this.item = item;
        this.mats = mats;
    }
}
