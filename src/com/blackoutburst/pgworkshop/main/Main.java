package com.blackoutburst.pgworkshop.main;

import com.blackoutburst.pgworkshop.commands.CommandEnd;
import com.blackoutburst.pgworkshop.commands.CommandMaxScore;
import com.blackoutburst.pgworkshop.commands.CommandStart;
import com.blackoutburst.pgworkshop.core.Core;
import com.blackoutburst.pgworkshop.utils.Utils;
import org.bukkit.*;
import org.bukkit.block.Furnace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main extends JavaPlugin implements Listener {

    public static World world;

    public static List<Location> priorityMaterials = new ArrayList<>();
    public static List<Location> materials = new ArrayList<>();
    public static List<Location> itemFrames = new ArrayList<>();

    public static Location spawn;
    public static Location gameSpawn;
    public static Location foremanLocation;
    public static boolean gameRunning = false;
    public static int maxScore = 5;

    @Override
    public void onDisable() {
        if (gameRunning)
            Core.end();
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        world = Bukkit.getWorlds().get(0);

        YamlConfiguration file = YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/material.yml"));
        Set<String> respawns = file.getConfigurationSection("loc").getKeys(false);
        for (final String i : respawns) {
            final double x = file.getDouble("loc."+i+".x");
            final double y = file.getDouble("loc."+i+".y");
            final double z = file.getDouble("loc."+i+".z");
            materials.add(new Location(world, x, y, z));
        }

        file = YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/priority_material.yml"));
        respawns = file.getConfigurationSection("loc").getKeys(false);
        for (final String i : respawns) {
            final double x = file.getDouble("loc."+i+".x");
            final double y = file.getDouble("loc."+i+".y");
            final double z = file.getDouble("loc."+i+".z");
            priorityMaterials.add(new Location(world, x, y, z));
        }

        file = YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/item_frame.yml"));
        respawns = file.getConfigurationSection("loc").getKeys(false);
        for (final String i : respawns) {
            final double x = file.getDouble("loc."+i+".x");
            final double y = file.getDouble("loc."+i+".y");
            final double z = file.getDouble("loc."+i+".z");
            itemFrames.add(new Location(world, x, y, z));
        }

        foremanLocation = new Location(world, -1769f, 39, 762.5f, 180, 0);
        spawn = new Location(world, -1774.5f, 39, 739.5f, 0, 0);
        gameSpawn = new Location(world, -1768.5f, 39, 759.5f, 0, 0);


        ItemStack sword = new ItemStack(Material.ARMOR_STAND);
        ShapedRecipe recipe = new ShapedRecipe(sword);

        recipe.shape("SSS", " S ", "SCS");
        recipe.setIngredient('C', Material.STEP, (byte) 3);
        recipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(recipe);

        Core.update();
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        if (gameRunning && Utils.isMaterial(event.getBlock().getLocation())) {
            if (event.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE))
                event.getBlock().setType(Material.REDSTONE_ORE);

            final ItemStack item = Utils.getDrop(event.getBlock().getType());

            Utils.playBreakSound(event.getBlock().getType(), event.getBlock().getLocation());
            event.getBlock().setType(Material.AIR);
            event.getPlayer().getInventory().addItem(item);
        }
    }

    @EventHandler
    public void onEntityUse(PlayerInteractEntityEvent event) {
        if (!gameRunning) return;
        if (event.getRightClicked().getType().equals(EntityType.VILLAGER)) {
            event.setCancelled(true);
        }
        if (event.getRightClicked().getType().equals(EntityType.VILLAGER) &&
            event.getPlayer().getInventory().contains(Core.requiredItem)) {
            Core.craftEnd = Instant.now();
            event.getPlayer().getInventory().clear();
            world.playSound(event.getPlayer().getLocation(), Sound.LEVEL_UP, 3f, 1f);
            event.getPlayer().sendMessage("§aYou completed this craft in: §b"+Utils.ROUND.format(((float) Duration.between(Core.craftBegin, Core.craftEnd).toMillis() / 1000.0f))+"s");
            Core.currentScore++;
            Core.board.set(event.getPlayer(), 11, "Progress: §a"+Core.currentScore+"/"+Main.maxScore);
            if (Core.currentScore >= maxScore) {
                event.setCancelled(true);
                Core.end();
                return;
            }

            Utils.chooseCraft(event.getPlayer());
            Core.board.set(event.getPlayer(), 13, "Craft: §e"+Core.craftName);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (gameRunning && event.getInventory().getType().equals(InventoryType.CRAFTING) &&
                event.getSlotType().equals(InventoryType.SlotType.CRAFTING)) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage("§cYou must use the crafting table!");
        }
    }

    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        final Furnace furnace = (Furnace) event.getBlock().getState();
        furnace.setCookTime((short) 200);
    }

    @EventHandler
    public void onInteraction(PlayerInteractEvent event) {
        if (!gameRunning) return;
        if (event.getClickedBlock() == null) return;
        if (event.getClickedBlock().getType().equals(Material.FURNACE) ||
            event.getClickedBlock().getType().equals(Material.BURNING_FURNACE)) {
            final Furnace furnace = (Furnace) event.getClickedBlock().getState();
            new BukkitRunnable() {
                int count = 0;
                @Override
                public void run() {
                    if (count >= 100) {
                        this.cancel();
                    }
                    furnace.setCookTime((short) 200);
                    count++;
                }
            }.runTaskTimer(Main.getPlugin(Main.class), 0L, 0L);

            furnace.getInventory().setFuel(new ItemStack(Material.COAL, 64));
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(spawn);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(gameRunning);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(gameRunning);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(gameRunning);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(gameRunning);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(gameRunning);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName().toLowerCase()) {
            case "start": new CommandStart().execute(sender); break;
            case "end": new CommandEnd().execute(sender); break;
            case "maxscore": new CommandMaxScore().execute(sender, args); break;
            default: return (true);
        }
        return (true);
    }
}

