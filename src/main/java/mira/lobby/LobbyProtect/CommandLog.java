package mira.lobby.LobbyProtect;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLog implements Listener {
    Plugin plugin;
    //この下がコンストラクタ
    public CommandLog(Plugin me) {
        this.plugin = me;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    public static File plugin_dir = new File("plugins//Lobby");
    public static File logs_dir = new File(plugin_dir, "CommandLogs");

    public CommandLog(){
        CheckFolder();
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        Player p =e.getPlayer();
        String cmd =e.getMessage();
        Date date =new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh:mm:ss");
        String Date_str = sdf.format(date);

        File player_log = new File(logs_dir, p.getName()+".yml");
        if(!player_log.exists()){
            try{
                player_log.createNewFile();
            }catch (IOException exception){
                System.out.print("aaaaaa");
                return;
            }
        }
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(player_log));
            bufferedWriter.write(Date_str + " | " + cmd + "/n");
            bufferedWriter.close();
        }catch (IOException e1){
            System.out.print("aaaaaaa");
        }
    }

    public void CheckFolder(){
        if(!plugin_dir.exists()){
            plugin_dir.mkdir();
        }

        if(!logs_dir.exists()){
            logs_dir.mkdir();
        }

    }
}