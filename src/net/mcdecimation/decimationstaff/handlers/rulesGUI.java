package net.mcdecimation.decimationstaff.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class rulesGUI {

    public rulesGUI() {
        this.openGUI();
        this.f3plusb();
        this.hacking();
        this.skin();
        this.advertising();
    }

    public Inventory openGUI() {
        Inventory inv = Bukkit.createInventory(null, 9, "§c§lDecimation Rules GUI");

        inv.setItem(0, f3plusb());
        inv.setItem(1, hacking());
        inv.setItem(2, skin());
        inv.setItem(3, advertising());

        return inv;
    }

    public ItemStack f3plusb() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§c§lF3+B");
        lore.add("§aClick here to view the options");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack hacking() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§c§lHacking");
        lore.add("§aClick here to view the options");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack skin() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§c§lIllegal Skins");
        lore.add("§aClick here to view the options");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack advertising() {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();

        meta.setDisplayName("§c§lAdvertising");
        lore.add("§aClick here to view the options");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
