package de.mrg4ming.commands;

import de.mrg4ming.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaintenanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.isOp()) {
            if(args.length == 0) {
                if(Main.getPlugin().maintenance) {
                    sender.sendMessage(Main.PREFiX + "§bMaintenance mode is currently '§aon§b'.");
                } else {
                    sender.sendMessage(Main.PREFiX + "§bMaintenance mode is currently '§coff§b'.");
                }
            } else if(args.length == 1) {
                switch (args[0]) {
                    case "on" -> {
                        Main.getPlugin().maintenance = true;
                        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                            if(!p.isOp()) p.kickPlayer(Main.PREFiX + "§bMaintenance mode was §cactivated§b!");
                        }
                        Main.getPlugin().saveConfig();
                        sender.sendMessage(Main.PREFiX + "§bMaintenance mode set to '§aon§b'.");
                    }
                    case "off" -> {
                        Main.getPlugin().maintenance = false;
                        Main.getPlugin().saveConfig();
                        sender.sendMessage(Main.PREFiX + "§bMaintenance mode set to '§coff§b'.");
                    }
                }
            }
        }

        return true;
    }
}
