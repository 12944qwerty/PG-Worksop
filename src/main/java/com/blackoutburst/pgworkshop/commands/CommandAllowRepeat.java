package com.blackoutburst.pgworkshop.commands;

import com.blackoutburst.pgworkshop.main.Main;
import org.bukkit.command.CommandSender;

public class CommandAllowRepeat {

    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cInvalid usage! Try §e/allowrepeat <true/false>");
            return;
        }

        boolean value;

        try {
            value = Boolean.parseBoolean(args[0]);
        } catch (Exception ignored) {
            sender.sendMessage("§cThe argument must be true or false!");
            return;
        }

        Main.allowRepeat = value;

        if (Main.allowRepeat) {
            sender.sendMessage("§bYou §acan §bget multiples times the same craft during this game");
        } else {
            sender.sendMessage("§bYou §ccan't §bget multiples times the same craft during this game");
        }
    }

}
