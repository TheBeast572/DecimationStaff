package net.mcdecimation.decimationstaff.handlers.punishments;

import net.mcdecimation.decimationstaff.commands.helpCommand;
import net.mcdecimation.decimationstaff.commands.punishCommand;
import net.mcdecimation.decimationstaff.files.playerbansFile;
import net.mcdecimation.decimationstaff.handlers.punishGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class fnP implements Listener {
    punishGUI punishGUI = new punishGUI();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(event.getCurrentItem().equals(punishGUI.f3plusb())) {
            event.setCancelled(true);
            player.openInventory(openGUI());

        } else if(event.getCurrentItem().equals(offense1())) {
            event.setCancelled(true);
            ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();

            Bukkit.dispatchCommand(sender, "/ban " + punishCommand.tname.get(player.getUniqueId()) + " 1w1s" + " FN Exploits");
            playerbansFile.createFile(punishCommand.tname.get(player.getUniqueId()), player.getName(), "FN Exploits", "1st Offense");
            punishCommand.tname.remove(player.getUniqueId());

        } else if(event.getCurrentItem().equals(offense2())) {
            event.setCancelled(true);
            ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();

            Bukkit.dispatchCommand(sender, "/ban " + punishCommand.tname.get(player.getUniqueId()) + " 1mo1s" + " Fn Exploits");
            playerbansFile.createFile(punishCommand.tname.get(player.getUniqueId()), player.getName(), "Fn Exploits", "2nd Offense");
            punishCommand.tname.remove(player.getUniqueId());
        }
    }

    public Inventory openGUI() {
        Inventory inv = Bukkit.createInventory(null, 9, "§c§lFN Exploits");

        inv.setItem(0, offense1());
        inv.setItem(8, offense2());

        return inv;
    }

    public ItemStack offense1() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§a§l1st Offense");
        lore.add("§a1 Week Ban");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack offense2() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§a§l2nd Offense");
        lore.add("§a1 Month Ban");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
