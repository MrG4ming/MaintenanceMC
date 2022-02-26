package de.mrg4ming.listeners;

import de.mrg4ming.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent e) {
        if(Main.getPlugin().maintenance) {
            e.setMotd(Main.getPlugin().maintenanceMotd);
        } else e.setMotd(Main.getPlugin().defaultMotd);
    }

}
