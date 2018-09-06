package net.mcdecimation.decimationstaff.commands;

import net.mcdecimation.decimationstaff.files.configFile;
import net.mcdecimation.decimationstaff.handlers.punishGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class punishCommand implements CommandExecutor {
    public static HashMap<UUID, String> tname = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if(!(sender instanceof Player)) return false;
        configFile configFile = new configFile();
        Player player = (Player) sender;
        String perms = configFile.getConfigFile().get("rulesGUIpermission").toString();

        punishGUI punishGUI = new punishGUI();

        if(commandlabel.equalsIgnoreCase("punish") && player.hasPermission(perms)) {
            if(args.length == 1) {
               Player target = Bukkit.getPlayerExact(args[0]);
               if(target != null) {
                   tname.put(player.getUniqueId(), target.getName());
                   player.openInventory(punishGUI.openGUI());
                   return true;
               } else {
                   player.sendMessage(" ");
                   player.sendMessage(" ");
                   player.sendMessage(" ");
                   player.sendMessage("§7§m----§r §cError §7§m----§r");
                   player.sendMessage(" ");
                   player.sendMessage("§7- §c§l§o" + configFile.getConfigFile().get("playernotfoundmessage"));
                   player.sendMessage(" ");
                   player.sendMessage("§7§m-------------------------");
                   player.sendMessage(" ");
                   player.sendMessage(" ");
                   player.sendMessage(" ");
                   return false;
               }
            } else if (args.length == 0) {
                player.sendMessage(" ");
                player.sendMessage(" ");
                player.sendMessage(" ");
                player.sendMessage("§7§m----§r §cHelp §7§m----§r");
                player.sendMessage(" ");
                player.sendMessage("§7- /punish §c§l§oPLAYERNAME");
                player.sendMessage(" ");
                player.sendMessage("§7§m-------------------------");
                player.sendMessage(" ");
                player.sendMessage(" ");
                player.sendMessage(" ");
                return false;
            }
        }

        return false;
    }
}
