package com.blackoutburst.pgworkshop.commands;

import com.blackoutburst.pgworkshop.core.Core;
import com.blackoutburst.pgworkshop.main.Main;
import org.bukkit.command.CommandSender;

public class CommandEnd {

    public void execute(CommandSender sender) {
        if (Main.gameRunning)
            Core.end();
        else
            sender.sendMessage("§cThere is no game running right now!");
    }

}
