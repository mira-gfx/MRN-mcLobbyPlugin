package mira.lobby;


import mira.lobby.Commands.BuildModeCommand;
import mira.lobby.Commands.LobbyCommnad;
import mira.lobby.Commands.ServerSystemCommand;
import mira.lobby.Commands.VandalismKickCommand;
import mira.lobby.GUI.GUI;
import mira.lobby.GUI.SettingGUI;
import mira.lobby.Listeners.ChatManeger;
import mira.lobby.Listeners.JoinLisner;
import mira.lobby.Listeners.Quit;
import mira.lobby.LobbyItem.TNTItem;
import mira.lobby.LobbyProtect.CommandLog;
import mira.lobby.LobbyProtect.LobbyProtect;
import mira.lobby.Vandalism.Vanbalism;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
@Override
public void onEnable() {

	getServer().getPluginManager().registerEvents(this, this);
	getCommand("build").setExecutor(new BuildModeCommand());
	getCommand("serversystem").setExecutor(new ServerSystemCommand());
	getCommand("lobby").setExecutor(new LobbyCommnad());
	getCommand("allkick").setExecutor(new VandalismKickCommand());
	new JoinLisner(this);
	new LobbyProtect(this);
	new Vanbalism(this);
	new Quit(this);
	new TNTItem(this);
	new CommandLog(this);
	new ChatManeger(this);
	new GUI(this);
	getLogger().info(ChatColor.BLUE + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	getLogger().info("       MRN-LOBBy-PluginY！起動完了！  ");
	getLogger().info("          by mira_gfx     ");
	getLogger().info( ChatColor.BLUE +"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
}

@Override
public void onDisable() {
	getLogger().info("-----------------------");
	getLogger().info("MRN-Lobby-PluginY");
	getLogger().info("-----------------------");
}
}

