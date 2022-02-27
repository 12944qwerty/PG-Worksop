package com.blackoutburst.pgworkshop.core;

import com.blackoutburst.pgworkshop.main.Main;
import com.blackoutburst.pgworkshop.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Core {

    public static void start() {
        Main.gameRunning = true;
        Utils.countdown();
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getWorlds().get(0).setDifficulty(Difficulty.PEACEFUL);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Utils.generateRessrouces();
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Main.gameSpawn);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 60L);
    }

    public static void end() {
        Main.gameRunning = false;
        Utils.cleanWorkshop();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.getInventory().clear();
            p.teleport(Main.spawn);
        }
    }
}
