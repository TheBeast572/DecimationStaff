package net.mcdecimation.decimationstaff.files;

import net.mcdecimation.decimationstaff.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class playerbansFile {

    private static File getbansFile(String playername) {
        File file = new File(Main.getPlugin(Main.class).getDataFolder() + File.separator + "playerbans", playername + ".yml");
        return file;
    }

    public static void createFile(String playername, String getwhopunished, String punishment, String offense) {
        File file = getbansFile(playername);
        YamlConfiguration data = YamlConfiguration.loadConfiguration(file);

        if(file.exists()) {
            data.set("punished-by", getwhopunished);
            data.set("punishment", punishment);
            data.set("offense", offense);
            data.set("has-been-punished-before", true);
        } else {
            data.set("punished-by", getwhopunished);
            data.set("punishment", punishment);
            data.set("offense", offense);
            data.set("has-been-punished-before", false);
            try {
                data.save(file);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
