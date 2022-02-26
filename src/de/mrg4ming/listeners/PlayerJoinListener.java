package de.mrg4ming.listeners;

import de.mrg4ming.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(Main.getPlugin().maintenance) {
            if(!e.getPlayer().isOp()) {
                e.setJoinMessage("");
                e.getPlayer().kickPlayer(Main.getPlugin().kickReason);
            } else {
                e.getPlayer().sendMessage(Main.PREFiX + Main.getPlugin().kickReason);
            }
        }
    }

}
