package mira.lobby.GUI;import org.bukkit.Bukkit;import org.bukkit.ChatColor;import org.bukkit.Material;import org.bukkit.entity.Player;import org.bukkit.inventory.Inventory;import org.bukkit.inventory.ItemStack;import org.bukkit.inventory.meta.ItemMeta;public class SettingGUI {    public static void SettingGUI(Player p){        Inventory i = Bukkit.createInventory(null, 18, ChatColor.GRAY + "設定/Setting");        ItemStack a1 = new ItemStack(Material.APPLE);        ItemMeta a1m = a1.getItemMeta();        ItemStack a2 = new ItemStack(Material.BEACON);        ItemMeta a2m = a2.getItemMeta();        ItemStack a3 = new ItemStack(Material.PAPER);        ItemMeta a3m = a3.getItemMeta();        a1m.setDisplayName("APPLE");        a1.setItemMeta(a1m);        a2m.setDisplayName("移動速度上昇を 消す/付ける ");        a2.setItemMeta(a2m);        a3m.setDisplayName("APPER");        a3.setItemMeta(a3m);        i.setItem(3, a1);        i.setItem(5, a2);        i.setItem(7, a3);        p.openInventory(i);    }}