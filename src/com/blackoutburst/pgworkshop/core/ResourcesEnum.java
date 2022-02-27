package com.blackoutburst.pgworkshop.core;

import org.bukkit.Material;
import org.bukkit.Sound;

public enum ResourcesEnum {
    STONE(Material.STONE, (byte) 0, Material.COBBLESTONE, (byte) 0, Sound.DIG_STONE),
    GRANITE(Material.STONE, (byte) 1, Material.COBBLESTONE, (byte) 0, Sound.DIG_STONE),
    LOG(Material.LOG, (byte) 1, Material.LOG, (byte) 0, Sound.DIG_WOOD),
    IRON_ORE(Material.IRON_ORE, (byte) 0, Material.IRON_ORE, (byte) 0, Sound.DIG_STONE),
    GOLD_ORE(Material.GOLD_ORE, (byte) 0, Material.GOLD_ORE, (byte) 0, Sound.DIG_STONE),
    OBSIDIAN(Material.OBSIDIAN, (byte) 0, Material.OBSIDIAN, (byte) 0, Sound.DIG_STONE),
    REDSTONE_ORE(Material.REDSTONE_ORE, (byte) 0, Material.REDSTONE, (byte) 0, Sound.DIG_STONE),
    DIAMOND_ORE(Material.DIAMOND_ORE, (byte) 0, Material.DIAMOND, (byte) 0, Sound.DIG_STONE),
    COBWEB(Material.WEB, (byte) 0, Material.STRING, (byte) 0, Sound.DIG_STONE),
    BOOKSHELF(Material.BOOKSHELF, (byte) 0, Material.BOOK, (byte) 0, Sound.DIG_WOOD),
    LAPIS_ORE(Material.LAPIS_ORE, (byte) 0, Material.INK_SACK, (byte) 4, Sound.DIG_STONE),
    EMERALD_ORE(Material.EMERALD_ORE, (byte) 0, Material.EMERALD, (byte) 0, Sound.DIG_STONE),
    SANDSTONE_SLAB(Material.STEP, (byte) 1, Material.STEP, (byte) 3, Sound.DIG_STONE),
    STONE_SLAB(Material.STEP, (byte) 0, Material.STEP, (byte) 3, Sound.DIG_STONE),
    MELON(Material.MELON_BLOCK, (byte) 0, Material.MELON, (byte) 0, Sound.DIG_WOOD);

    public final Material block;
    public final byte blockData;
    public final Material drop;
    public final byte dropData;
    public final Sound breakSound;

    ResourcesEnum(Material block, byte blockData, Material drop, byte dropData, Sound breakSound) {
        this.block = block;
        this.blockData = blockData;
        this.drop = drop;
        this.dropData = dropData;
        this.breakSound = breakSound;
    }
}
