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
        Utils.countdown();
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getWorlds().get(0).setDifficulty(Difficulty.PEACEFUL);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.getInventory().clear();
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(Main.gameSpawn);
                }
            }
        }.runTaskLater(Main.getPlugin(Main.class), 60L);
    }

    public static void end() {
        Utils.cleanWorkshop();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleport(Main.spawn);
        }
    }
}
