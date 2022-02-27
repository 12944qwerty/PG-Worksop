package com.blackoutburst.pgworkshop.core;

import org.bukkit.Material;

public enum ResourcesEnum {
    STONE(Material.STONE, (byte) 0, Material.COBBLESTONE, (byte) 0),
    GRANITE(Material.STONE, (byte) 1, Material.COBBLESTONE, (byte) 0),
    LOG(Material.LOG, (byte) 1, Material.LOG, (byte) 0),
    IRON_ORE(Material.IRON_ORE, (byte) 0, Material.IRON_ORE, (byte) 0),
    GOLD_ORE(Material.IRON_ORE, (byte) 0, Material.GOLD_ORE, (byte) 0),
    OBSIDIAN(Material.OBSIDIAN, (byte) 0, Material.OBSIDIAN, (byte) 0),
    REDSTONE_ORE(Material.REDSTONE_ORE, (byte) 0, Material.REDSTONE, (byte) 0),
    DIAMOND_ORE(Material.DIAMOND_ORE, (byte) 0, Material.DIAMOND, (byte) 0),
    COBWEB(Material.WEB, (byte) 0, Material.STRING, (byte) 0),
    BOOKSHELF(Material.BOOKSHELF, (byte) 0, Material.BOOK, (byte) 0),
    LAPIS_ORE(Material.LAPIS_ORE, (byte) 0, Material.INK_SACK, (byte) 4),
    EMERALD_ORE(Material.EMERALD_ORE, (byte) 0, Material.EMERALD, (byte) 0),
    SANDSTONE_SLAB(Material.STEP, (byte) 1, Material.STEP, (byte) 3),
    STONE_SLAB(Material.STEP, (byte) 0, Material.STEP, (byte) 3),
    MELON(Material.MELON_BLOCK, (byte) 0, Material.MELON, (byte) 0);

    public final Material block;
    public final byte blockData;
    public final Material drop;
    public final byte dropData;

    ResourcesEnum(Material block, byte blockData, Material drop, byte dropData) {
        this.block = block;
        this.blockData = blockData;
        this.drop = drop;
        this.dropData = dropData;
    }
}
