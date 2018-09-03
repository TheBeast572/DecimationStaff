package net.mcdecimation.decimationstaff.commands;

import net.mcdecimation.decimationstaff.handlers.rulesGUI;
import net.mcdecimation.decimationstaff.utils.Reference;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class RulesCommand implements CommandExecutor {
    public static HashMap<UUID, String> tname = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(commandlabel.equalsIgnoreCase("decirules") && player.hasPermission("decistaff.rules.allow")) {
                if(args.length >= 0) {
                    if(!(args[0].isEmpty())) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(target != null) {
                            rulesGUI rulesGUI = new rulesGUI();

                            tname.put(player.getUniqueId(), target.getName());

                            player.openInventory(rulesGUI.openGUI());
                            return true;
                        } else {
                            player.sendMessage(Reference.PREFIX + "§cThat player does not exist!");
                            return false;
                        }
                    } else {
                        player.sendMessage(Reference.PREFIX + "§cLooks like you need help. To do this command, enter the following:");
                        player.sendMessage("§c/decirules <Player>");
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
