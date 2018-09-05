package net.mcdecimation.decimationstaff.files;

import net.mcdecimation.decimationstaff.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class configFile {

    public configFile() {
        this.getConfigFile();
        this.reload();
        this.ymlConfig();
    }

    public File getConfigFile() {
        File file = new File(Main.getPlugin(Main.class).getDataFolder(), "config.yml");
        return file;
    }

    public YamlConfiguration ymlConfig() {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(getConfigFile());
        return config;
    }

    public void reload() {

        if(!Main.getPlugin().getDataFolder().exists()) {
            Main.getPlugin().getDataFolder().mkdir();
        }

        if(!getConfigFile().exists()) {
            try {
                getConfigFile().createNewFile();
                YamlConfiguration config = YamlConfiguration.loadConfiguration(getConfigFile());
                config.addDefault("subCommand1", true);
                config.addDefault("subCommand2", true);
                config.addDefault("subCommand1info", true);
                config.addDefault("subCommand2info", true);
                config.addDefault("subCommand1title", true);
                config.addDefault("subCommand1line1", true);
                config.addDefault("subCommand1line2", true);
                config.addDefault("subCommand2title", true);
                config.addDefault("subCommand2line1", true);
                config.addDefault("subCommand2line2", true);
                config.addDefault("reloadsubCommand", true);
                config.addDefault("reloadPermission", true);
                config.addDefault("reloadOutputSuccess", true);
                config.addDefault("rulesGUIpermission", true);
            }
            catch (IOException e) {
                e.printStackTrace();

            }


        }
    }


}
