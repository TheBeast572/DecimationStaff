package net.mcdecimation.decimationstaff.files;

import net.mcdecimation.decimationstaff.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class configFile {

    public File file = new File(Main.getPlugin(Main.class).getDataFolder(), "config.yml");
    public YamlConfiguration data = YamlConfiguration.loadConfiguration(file);

    public configFile() {
        this.reload();
        this.getConfigFile();
    }

    public void reload() {
        if(!(file.exists())) {
            data.set("subCommand1title", "§cDecimation Help");
            data.set("subCommand1line1", "§7Line 1");
            data.set("subCommand1line2", "§7Line 2");

            data.set("subCommand2title", "§cDiscord Help");
            data.set("subCommand2line1", "§7Line 1");
            data.set("subCommand2line2", "§7Line 2");
            data.set("reloadsubCommand", "reload");
            data.set("reloadPermission", "decimationstaff.help.reload");
            data.set("reloadOutputSuccess", "§7Decimation Help config §a§osuccessfully§7 reloaded");
            data.set("rulesGUIpermission", "decimationstaff.rules.allow");
            data.set("playernotfoundmessage", "§cThat player does not exist!");
            try {
                data.save(file);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public YamlConfiguration getConfigFile() {
        return data;
    }
}
