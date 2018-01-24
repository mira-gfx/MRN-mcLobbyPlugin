package mira.lobby.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.Random;

public class ServerSystemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ServerSystem")) {
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage(ChatColor.GREEN + "✔§l認証に成功しました");
                sender.sendMessage("=-=-=-=-=-=ServerSystem--=-=-=-=-=-=");
                sender.sendMessage("OS-info=" + System.getProperty("os.name"));
                sender.sendMessage("OS-Arch=" + System.getProperty("os.arch"));
                sender.sendMessage("UserName=" + System.getProperty("user.name"));
                sender.sendMessage("JavaVersion=" + System.getProperty("Java.Version"));
                sender.sendMessage("Memory(使用量)=" + Runtime.getRuntime().totalMemory());
                sender.sendMessage("Memory(使用可能量)=" + Runtime.getRuntime().maxMemory());
                sender.sendMessage("Memory(空いてるメモリ)=" + Runtime.getRuntime().freeMemory());
                sender.sendMessage("BukkitVersion=" + Bukkit.getVersion());
                sender.sendMessage("MaxPlayer=" + Bukkit.getMaxPlayers());
                sender.sendMessage("Worlds=" + Bukkit.getWorlds().toString());
                sender.sendMessage("Plugins=" + Bukkit.getPluginManager().getPlugins().toString());
                Bukkit.getServer().getLogger().info(sender.getName() + "がServerSystemコマンドを使用してサーバの情報を手に入れました");
                return true;
            } else

                sender.sendMessage(ChatColor.RED + "§lコンソールから実行してください(そのうち開発します。僕の技術力では無理だった)");
            Bukkit.getServer().getLogger().info(sender.getName() + "がServerSystemのコマンドを使用して情報を手に入れようとしましたが、失敗しました");

            return false;
        }
        return false;
    }
}

