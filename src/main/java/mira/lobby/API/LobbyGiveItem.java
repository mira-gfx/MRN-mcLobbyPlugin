package mira.lobby.API;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyGiveItem {

    public static void setItem(Player p) {

        Inventory inv = p.getInventory();
        ItemStack paper = new ItemStack(Material.BOOK);
        ItemMeta paperm = paper.getItemMeta();
        paperm.setDisplayName(ChatColor.AQUA + "メニュー/Menu");
        paper.setItemMeta(paperm);

        ItemStack St = new ItemStack(Material.PAPER);
        ItemMeta Stm = paper.getItemMeta();
        Stm.setDisplayName(ChatColor.GRAY + "設定/Settng");
        St.setItemMeta(Stm);

        inv.setItem(0,St);
        inv.setItem(8,paper);

    }
}