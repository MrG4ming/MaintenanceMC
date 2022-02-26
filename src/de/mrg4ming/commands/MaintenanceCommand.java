package de.mrg4ming.commands;

import de.mrg4ming.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MaintenanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.isOp()) {
            if(args.length == 0) {
                if(Main.getPlugin().maintenance) {
                    sender.sendMessage(Main.PREFiX + "§bMaintenance mode is currently '§aon§d'.");
                } else {
                    sender.sendMessage(Main.PREFiX + "§bMaintenance mode is currently '§coff§d'.");
                }
            } else if(args.length == 1) {
                switch (args[0]) {
                    case "on" -> {
                        Main.getPlugin().maintenance = true;
                        Main.getPlugin().saveConfig();
                        sender.sendMessage(Main.PREFiX + "§bMaintenance mode set to '§aon§d'.");
                    }
                    case "off" -> {
                        Main.getPlugin().maintenance = false;
                        Main.getPlugin().saveConfig();
                        sender.sendMessage(Main.PREFiX + "§bMaintenance mode set to '§coff§d'.");
                    }
                }
            }
        }

        return true;
    }
}
