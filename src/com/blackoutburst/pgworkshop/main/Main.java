package com.blackoutburst.pgworkshop.main;

import com.blackoutburst.pgworkshop.commands.CommandEnd;
import com.blackoutburst.pgworkshop.commands.CommandMaxScore;
import com.blackoutburst.pgworkshop.commands.CommandStart;
import com.blackoutburst.pgworkshop.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main extends JavaPlugin implements Listener {

    public static List<Location> priorityMaterials = new ArrayList<>();
    public static List<Location> materials = new ArrayList<>();

    public static Location spawn;
    public static Location gameSpawn;
    public static boolean gameRunning = false;
    public static int maxScore = 6;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        YamlConfiguration file = YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/material.yml"));
        Set<String> respawns = file.getConfigurationSection("loc").getKeys(false);
        for (final String i : respawns) {
            final double x = file.getDouble("loc."+i+".x");
            final double y = file.getDouble("loc."+i+".y");
            final double z = file.getDouble("loc."+i+".z");
            materials.add(new Location(Bukkit.getWorlds().get(0), x, y, z));
        }

        file = YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("/priority_material.yml"));
        respawns = file.getConfigurationSection("loc").getKeys(false);
        for (final String i : respawns) {
            final double x = file.getDouble("loc."+i+".x");
            final double y = file.getDouble("loc."+i+".y");
            final double z = file.getDouble("loc."+i+".z");
            priorityMaterials.add(new Location(Bukkit.getWorlds().get(0), x, y, z));
        }

        spawn = new Location(Bukkit.getWorlds().get(0), -1774.5f, 40, 739.5f, 0, 0);
        gameSpawn = new Location(Bukkit.getWorlds().get(0), -1768.5f, 40, 759.5f, 0, 0);
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
            case "start": new CommandStart().execute(); break;
            case "end": new CommandEnd().execute(); break;
            case "maxscore": new CommandMaxScore().execute(sender, args); break;
            default: return (true);
        }
        return (true);
    }
}

