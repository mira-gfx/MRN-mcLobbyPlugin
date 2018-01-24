package mira.lobby.LobbyItem;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class TNTItem implements Listener {
    Plugin plugin;
    private Player p;

    //この下がコンストラクタ
    public TNTItem(Plugin me) {
        this.plugin = me;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTNTPlace(BlockPlaceEvent e){
        Player p =e.getPlayer();
        Location loc = e.getBlock().getLocation();

        if (e.getBlock().getType() == Material.TNT) {
            p.getWorld().spawnEntity(loc, EntityType .PRIMED_TNT);
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onExplosinon(EntityExplodeEvent e){

        e.setCancelled(true);
        Location loc = e.getLocation();
        loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 5, false, false);

for (final Entity ent : e.getEntity().getNearbyEntities(4, 6, 4)){
    Vector v = ent.getLocation().toVector().subtract(loc.toVector());

    if(v.getX() > 0){
        v.setX(4 - v.getX());
    }

    if(v.getZ() > 0){
        v.setZ(4 - v.getZ());
    }
    ent.setVelocity(v.add(new Vector(1.3, 3, 1.3)));

}

    }
}