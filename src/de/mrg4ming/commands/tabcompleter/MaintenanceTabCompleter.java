package de.mrg4ming.commands.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceTabCompleter implements TabCompleter {

    String[] commands = {"on", "off"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> result = new ArrayList<>();

        if(sender.isOp()) {
            if(args.length == 1) {
                for(String s : commands) {
                    if(s.toLowerCase().startsWith(args[0].toLowerCase())) {
                        result.add(s);
                    }
                }
            }
        }

        return result;
    }
}
