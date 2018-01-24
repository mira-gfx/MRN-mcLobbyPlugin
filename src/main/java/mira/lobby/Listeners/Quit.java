package mira.lobby.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class Quit implements Listener {
    Plugin plugin;

    //この下がコンストラクタ
    public Quit(Plugin me) {
        this.plugin = me;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    //pleyer系
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Inventory i = p.getInventory();
        e.setQuitMessage(ChatColor.DARK_GRAY + "§lQuit>>" + e.getPlayer().getName());
        i.clear();
    }


}
