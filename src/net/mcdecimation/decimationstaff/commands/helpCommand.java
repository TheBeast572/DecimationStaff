package net.mcdecimation.decimationstaff.commands;

import net.mcdecimation.decimationstaff.files.configFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCommand implements CommandExecutor {
    configFile configFile = new configFile();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("help")) {
                if(args.length == 0) {
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage("§7§m----§r §cHelp §7§m----§r");
                    p.sendMessage(" ");
                    p.sendMessage("§7- /help §c§l§o" + configFile.ymlConfig().get("subCommand1") + " " + configFile.ymlConfig().get("subCommand1info"));
                    p.sendMessage("§7- /help §c§l§o" + configFile.ymlConfig().get("subCommand2") + " " + configFile.ymlConfig().get("subCommand2info"));
                    p.sendMessage(" ");
                    p.sendMessage("§7§m-------------------------");
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    return false;
                }else if(args.length == 1) {
                    if(args[0].equalsIgnoreCase((String) configFile.ymlConfig().get("subCommand1"))){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage("§7§m----§r " + configFile.ymlConfig().get("subCommand1title") + " §7§m----§r");
                        p.sendMessage(" ");
                        p.sendMessage("§7- " + configFile.ymlConfig().get("subCommand1line1" + ""));
                        p.sendMessage("§7- " + configFile.ymlConfig().get("subCommand1line2" + ""));
                        p.sendMessage(" ");
                        p.sendMessage("§7§m-------------------------");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        return true;
                    }else if(args[0].equalsIgnoreCase((String) configFile.ymlConfig().get("subCommand2"))){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage("§7§m----§r " + configFile.ymlConfig().get("subCommand2title") + " §7§m----§r");
                        p.sendMessage(" ");
                        p.sendMessage("§7- " + configFile.ymlConfig().get("subCommand2line1" + ""));
                        p.sendMessage("§7- " + configFile.ymlConfig().get("subCommand2line2" + ""));
                        p.sendMessage(" ");
                        p.sendMessage("§7§m-------------------------");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        return true;
                    }else if(args[0].equalsIgnoreCase((String) configFile.ymlConfig().get("reloadsubCommand"))){
                        if(sender.hasPermission((String) configFile.ymlConfig().get("reloadPermission"))) {
                            configFile.reload();
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage((String) configFile.ymlConfig().get("reloadOutputSuccess"));
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            return true;
                        }

                    }
                }
            }
        }else Bukkit.getConsoleSender().sendMessage("§4You can only use this command as a player.");
        return false;
    }
}
