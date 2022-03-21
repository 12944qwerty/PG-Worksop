package com.blackoutburst.pgworkshop.commands;

import com.blackoutburst.pgworkshop.core.Core;
import com.blackoutburst.pgworkshop.main.Main;
import org.bukkit.command.CommandSender;

public class CommandStart {

    public void execute(CommandSender sender) {
        if (!Main.gameRunning)
            Core.start();
        else
            sender.sendMessage("§cYou must end the previous game before starting a new one!");
    }

}
