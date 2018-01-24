package mira.lobby.Listeners;
import mira.lobby.API.LobbyGiveItem;
import mira.lobby.API.ScoreBord;
import org.bukkit.*;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;

public class JoinLisner implements Listener {
	Plugin plugin;
	private Player p;

	//この下がコンストラクタ
	public JoinLisner(Plugin me) {
		this.plugin = me;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
//log系
	public void onPlayerLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		plugin.getLogger().info(p.getName() + "がログインを試みています");
		//名前
		plugin.getLogger().info("[Login info]" + p.getName());
		//OPかどうか
		plugin.getLogger().info("[Player OP info]=" + p.isOp());
		//IP取得
		plugin.getLogger().info("[PP IP info]=" + e.getAddress().getHostAddress());
		//hostName取得
		plugin.getLogger().info("[Player HostName info]=" + e.getHostname());
		//UUIDｼｭﾄｸ
		plugin.getLogger().info("[UUID info]=" + p.getUniqueId());


	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		//連続処理用のあれ
		int i;
		//因数格納
		Player p = e.getPlayer();
		//三頂演算子
		String op = p.isOp() ? "はい" : "いいえ";
		//FastJoin?
		if (!p.hasPlayedBefore()) {
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "" + p.getName() + "さんはこのサーバに初めて接続しました");
			for (i = 0; i < 10; i++) {
				Firework f = e.getPlayer().getWorld().spawn(p.getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.with(Type.STAR)
						.withColor(Color.YELLOW)
						.build());
				fm.setPower(1);
				f.setFireworkMeta(fm);


			}


		} else {

			//LobbyTp
			p.teleport(new Location(Bukkit.getWorld("Lobbytest"), -2.5, 77, -23));
//OPにやる
			for (Player on : Bukkit.getOnlinePlayers()) {
				if (on.isOp()) {
					on.sendMessage(ChatColor.RED + "§l[JoinInfo]" + p.getName() + "§lがサーバに入りました");
					on.sendMessage(ChatColor.RED + "§l===============" + p.getName() + "§lの情報" + "§l=============");
					on.sendMessage(ChatColor.RED + "§lゲームモード=" + p.getGameMode());
					on.sendMessage(ChatColor.RED + "§lUUID=" + p.getUniqueId());
					on.sendMessage(ChatColor.RED + "§lOP=" + op);
				}
			}
			//コンソールLog
			plugin.getLogger().info("[Server-States]" + Bukkit.getServer().getOnlinePlayers() + "/" + Bukkit.getServer().getMaxPlayers());
			plugin.getLogger().info("[UUID info]=" + p.getUniqueId());
			plugin.getLogger().info("[GameMode info]=" + p.getGameMode());
			plugin.getLogger().info("[OP info]=" + op);
			//APIからGiveしてくる。
			LobbyGiveItem.setItem(p);
			ScoreBord.ScoreBordAdd(p);
			//フード&ヘルス
			p.setFoodLevel(20);
			p.setHealth(20);
			//Log
			plugin.getLogger().info(p.getName() + "がサーバに入りました");
			Bukkit.getScheduler().runTaskLater(plugin, () -> {
				p.sendMessage("§n§l=================================================================");
				p.sendMessage("                       §b§l> >> MiraNetWork MRN << <                   ");
				p.sendMessage("                    §b§lWelcome to the MiraNetWork                    ");
				p.sendMessage("                        §b§lMRSにようこそ                    ");
				p.sendMessage("                        §b§lルールを守って楽しもう!                 ");
				p.sendMessage("§n§l=========================================================");
				e.setJoinMessage(ChatColor.YELLOW + "§lJOIN>>" + ChatColor.GREEN + p.getName());

				for (Player on : Bukkit.getOnlinePlayers()) {
					on.playSound(on.getLocation(), Sound.SUCCESSFUL_HIT, 10, 2);
				}
				p.playSound(p.getLocation(), Sound.PORTAL_TRIGGER,1,1);
				//花火召喚
				Firework f = e.getPlayer().getWorld().spawn(p.getLocation(), Firework.class);
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						.flicker(false)
						.trail(true)
						.with(Type.CREEPER)
						.withColor(Color.YELLOW)
						.build());
				fm.setPower(1);
				f.setFireworkMeta(fm);
			}, 17);
		}
	}
}




