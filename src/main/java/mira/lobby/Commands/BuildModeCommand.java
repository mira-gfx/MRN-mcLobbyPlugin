package mira.lobby.Commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mira.lobby.API.BuildModeGiveItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BuildModeCommand implements CommandExecutor {

    public static HashMap<String, Boolean> Build = new HashMap<>();
    public List<Player> getOnlineOps(){
	    List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
	    List<Player> onlineOPs = new ArrayList<>();

	    for(Player player : players){
	        if(player.isOp()){
	            onlineOPs.add(player);
	        }
	    }
	    return onlineOPs;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if("build".equalsIgnoreCase(command.getName())){
            if (args.length != 0) {
                // 引数がある
                if(args[0].equalsIgnoreCase("on")) {
                    //onコマンドが呼ばれた
                	if(sender instanceof Player){
                	    //プレイヤー？
                	    if (sender.isOp() == true) {
                            Player p = (Player) sender;
                            Build.put(p.getName(), true);
                            //OP処理
                            Bukkit.getOnlinePlayers()
                                    .stream()
                                    .filter(OfflinePlayer::isOp)
                                    .forEach(op -> {
                                        //Opへメッセージ
                                        op.sendMessage("§l[警告]" + ChatColor.DARK_RED + p.getName() + "§lがBuildモードになりました");
                                        Bukkit.getServer().broadcastMessage(ChatColor.WHITE + p.getName() + "§lが建築モードになりました");
                                        //クリエ化
                                        p.setGameMode(GameMode.CREATIVE);
                                        p.sendMessage(ChatColor.YELLOW + "あなたは建築モードになりました");
                                        //Give
                                        BuildModeGiveItem.setAll(sender);
                                    });
                            return true;
                            //終わり
                        }
                }else {
                	    //senderがPlayerじゃ無かった
                	    sender.sendMessage( ChatColor.RED + "§l貴方はプレイヤーでは無かったので、処理ができませんでした。");
                	    return false;
                    }
            }else  if(args[0].equalsIgnoreCase("off")) {
                    //因数がOffだったら
            	Player p = (Player) sender;
            	Build.put(p.getName(), false);
            	Inventory inv = p.getInventory();
            	inv.clear();
            	sender.sendMessage("BuildMoodをOffにしました。");
            	Bukkit.broadcastMessage(sender.getName() + "が建築モードをOffにしました");
                            return true;
            	}else{
                    //因数が付いてなかった。
                    sender.sendMessage(ChatColor.RED + "§l使い方が間違っています。");
                    return false;
                }

            }
        }
        return false;
}
}
