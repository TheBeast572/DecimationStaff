package net.mcdecimation.decimationstaff;

import net.mcdecimation.decimationstaff.commands.helpCommand;
import net.mcdecimation.decimationstaff.commands.punishCommand;
import net.mcdecimation.decimationstaff.files.configFile;
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
        configFile configFile = new configFile();

        configFile.reload();
        registerEvents();
        registerCommands();

        plugin = this;
    }

    public void onDisable() {
        configFile configFile = new configFile();

        configFile.reload();

        plugin = null;
    }

    public static Plugin getPlugin() {
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
        this.getCommand("help").setExecutor(new helpCommand());
        this.getCommand("punish").setExecutor(new punishCommand());
    }
}
