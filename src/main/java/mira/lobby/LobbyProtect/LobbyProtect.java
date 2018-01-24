package mira.lobby.LobbyProtect;

import mira.lobby.API.LobbyGiveItem;
import mira.lobby.Commands.BuildModeCommand;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class LobbyProtect implements Listener {
	Plugin plugin;

	//この下がコンストラクタ
	public LobbyProtect(Plugin me) {
		this.plugin = me;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}


	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();

		}


	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onSpawnMob(CreatureSpawnEvent e) {
		if (e.getEntityType() == EntityType.PLAYER) {
			e.setCancelled(false);

		} else if (e.getEntityType() == EntityType.ZOMBIE) {
			e.setCancelled(true);
		} else if (e.getEntityType() == EntityType.CREEPER) {
			e.setCancelled(true);
		} else if (e.getEntityType() == EntityType.SKELETON) {
			e.setCancelled(true);
		} else if (e.getEntityType() == EntityType.SLIME) {
			e.setCancelled(true);
		} else if (e.getEntityType() == EntityType.SPIDER) {
			e.setCancelled(true);
		} else if (e.getEntityType() == EntityType.ENDERMAN) {
			e.setCancelled(true);
		} else if(e.getEntityType() == EntityType.WEATHER){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void foodchange(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}

	@EventHandler
	public void Respawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		LobbyGiveItem.setItem(p);
	}

	@EventHandler
	public void Death(PlayerDeathEvent e) {
		e.setDeathMessage(e.getEntity().getName() + "は死んじゃった(´・ω・｀)");
	}
	@EventHandler
	public void Damege (EntityDamageEvent e){
		if(e.getEntityType() == EntityType.PLAYER){
			Player p = (Player) e.getEntity();
			p.setHealth(20);
		}else{
			e.setCancelled(false);
		}
	}
}