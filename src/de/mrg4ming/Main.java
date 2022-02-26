package de.mrg4ming;

import de.mrg4ming.commands.MaintenanceCommand;
import de.mrg4ming.commands.tabcompleter.MaintenanceTabCompleter;
import de.mrg4ming.config.Config;
import de.mrg4ming.listeners.PlayerJoinListener;
import de.mrg4ming.listeners.ServerListPingListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Main extends JavaPlugin {

    private static Main plugin;

    public static final String PREFiX = "§8[§5MaintenanceE§8]§r ";

    public boolean maintenance = false;

    public Config cfg;

    public String defaultMotd;
    public String maintenanceMotd;
    public String kickReason;


    @Override
    public void onEnable() {
        if(plugin == null) {
            plugin = this;
        } else return;

        loadConfig();

        getCommand("maintenance").setExecutor(new MaintenanceCommand());
        getCommand("maintenance").setTabCompleter(new MaintenanceTabCompleter());

        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new ServerListPingListener(), this);
        pm.registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static Main getPlugin() {
        return plugin;
    }

    public void loadConfig() {
        cfg = new Config("main");

        try {
            if(!cfg.contains("maintenance.motd")) cfg.set("maintenance.motd", "§dServer §bis currently in §4maintenance mode§b!");
            if(!cfg.contains("maintenance.active")) cfg.set("maintenance.active", false);
            if(!cfg.contains("maintenance.kickreason")) cfg.set("maintenance.kickreason", "§dServer§b is currently in §4maintenance mode§b!");
            if(!cfg.contains("default.ignore")) cfg.set("default.ignore", true);
            if(!cfg.contains("default.motd")) cfg.set("default.motd", getPlugin().getServer().getMotd());
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(!((boolean) cfg.get("default.ignore"))) {
            defaultMotd = (String) cfg.get("default.motd");
        } else defaultMotd = getServer().getMotd();

        maintenanceMotd = (String) cfg.get("maintenance.motd");
        maintenance = (boolean) cfg.get("maintenance.active");
        kickReason = (String) cfg.get("maintenance.kickreason");
    }

    public void saveConfig() {
        try {
            cfg.set("maintenance.motd", maintenanceMotd);
            cfg.set("maintenance.active", maintenance);
            cfg.set("maintenance.kickreason", kickReason);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
