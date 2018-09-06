package net.mcdecimation.decimationstaff.commands;

import net.mcdecimation.decimationstaff.Main;
import net.mcdecimation.decimationstaff.files.configFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player) {
            configFile configFile = new configFile();
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("help")) {
                if(args.length == 0) {
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage("§7§m----§r §cHelp §7§m----§r");
                    p.sendMessage(" ");
                    p.sendMessage("§7- /help §c§l§o" + configFile.getConfigFile().get("subCommand1") + " " + configFile.getConfigFile().get("subCommand1info"));
                    p.sendMessage("§7- /help §c§l§o" + configFile.getConfigFile().get("subCommand2") + " " + configFile.getConfigFile().get("subCommand2info"));
                    p.sendMessage(" ");
                    p.sendMessage("§7§m-------------------------");
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    return false;
                }else if(args.length == 1) {
                    if(args[0].equalsIgnoreCase((String) configFile.getConfigFile().get("subCommand1"))){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage("§7§m----§r " + configFile.getConfigFile().get("subCommand1title") + " §7§m----§r");
                        p.sendMessage(" ");
                        p.sendMessage("§7- " + configFile.getConfigFile().get("subCommand1line1" + ""));
                        p.sendMessage("§7- " + configFile.getConfigFile().get("subCommand1line2" + ""));
                        p.sendMessage(" ");
                        p.sendMessage("§7§m-------------------------");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        return true;
                    }else if(args[0].equalsIgnoreCase((String) configFile.getConfigFile().get("subCommand2"))){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage("§7§m----§r " + configFile.getConfigFile().get("subCommand2title") + " §7§m----§r");
                        p.sendMessage(" ");
                        p.sendMessage("§7- " + configFile.getConfigFile().get("subCommand2line1" + ""));
                        p.sendMessage("§7- " + configFile.getConfigFile().get("subCommand2line2" + ""));
                        p.sendMessage(" ");
                        p.sendMessage("§7§m-------------------------");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        return true;
                    }
                }
            }
        }else Bukkit.getConsoleSender().sendMessage("§4You can only use this command as a player.");
        return false;
    }
}
