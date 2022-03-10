package com.blackoutburst.pgworkshop.commands;

import com.blackoutburst.pgworkshop.main.Main;
import org.bukkit.command.CommandSender;

public class CommandDelay {

    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cInvalid usage! Try §e/delay <value>");
            return;
        }

        float value;

        try {
            value = Float.parseFloat(args[0]);
        } catch (Exception ignored) {
            sender.sendMessage("§cThe delay must be a valid number!");
            return;
        }

        if (value <= 0) {
            sender.sendMessage("§cThe delay must be at least 0!");
            return;
        }

        Main.timeDelay = value;
        sender.sendMessage("§bThe delay between craft has been set to §6"+value);
    }

}
