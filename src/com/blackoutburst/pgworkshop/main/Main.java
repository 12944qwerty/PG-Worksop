package com.blackoutburst.pgworkshop.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Location spawn;
    public static boolean gameRunning;

    @Override
    public void onEnable() {
        spawn = new Location(Bukkit.getWorlds().get(0), -1774.5f, 40, 739.5f);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(spawn);
    }

}

