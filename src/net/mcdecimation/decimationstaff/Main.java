package net.mcdecimation.decimationstaff;

import net.mcdecimation.decimationstaff.commands.RulesCommand;
import net.mcdecimation.decimationstaff.handlers.punishments.aP;
import net.mcdecimation.decimationstaff.handlers.punishments.fnP;
import net.mcdecimation.decimationstaff.handlers.punishments.hP;
import net.mcdecimation.decimationstaff.handlers.punishments.sP;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    static Plugin plugin;

    public void onEnable() {
        registerEvents();
        registerCommands();
        plugin = this;
    }

    public void onDisable() {
        plugin = null;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new aP(), this);
        pm.registerEvents(new fnP(), this);
        pm.registerEvents(new hP(), this);
        pm.registerEvents(new sP(), this);
    }

    public void registerCommands() {
        this.getCommand("decirules").setExecutor(new RulesCommand());
    }
}
