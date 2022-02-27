package com.blackoutburst.pgworkshop.main;

import com.blackoutburst.pgworkshop.commands.CommandEnd;
import com.blackoutburst.pgworkshop.commands.CommandMaxScore;
import com.blackoutburst.pgworkshop.commands.CommandStart;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Location spawn;
    public static Location gameSpawn;
    public static boolean gameRunning = false;
    public static int maxScore = 6;

    @Override
    public void onEnable() {
        spawn = new Location(Bukkit.getWorlds().get(0), -1774.5f, 40, 739.5f, 0, 0);
        gameSpawn = new Location(Bukkit.getWorlds().get(0), -1764.5f, 40, 758.5f, 0, 0);
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

