package mira.lobby.API;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildModeGiveItem {

	public static void setAll(CommandSender sender) {

		Player p = (Player) sender;
		Inventory inv = p.getInventory();


			ItemStack wand = new ItemStack(Material.WOOD_AXE);
			ItemMeta wandm = wand.getItemMeta();
			wandm.setDisplayName(ChatColor.RED + "WorldEdit-Wand");
					wand.setItemMeta(wandm);

					ItemStack sp = new ItemStack(Material.DIAMOND_PICKAXE);
					ItemMeta spm = sp.getItemMeta();
					spm.setDisplayName(ChatColor.GREEN + "WorldEdit-SuperPickle");
							sp.setItemMeta(spm);

							ItemStack bs = new ItemStack(Material.ARROW);
							ItemMeta bsm = bs.getItemMeta();
							bsm.setDisplayName(ChatColor.DARK_RED + "VoxelSniper-Arrow");
									bs.setItemMeta(bsm);

									ItemStack cmp = new ItemStack(Material.COMPASS);
									ItemMeta cmpm = cmp.getItemMeta();
									cmpm.setDisplayName(ChatColor.RED + "WorldEdit-Compass");
											cmp.setItemMeta(cmpm);

									inv.setItem(0, wand);
									inv.setItem(1, sp);
									inv.setItem(2, bs);
									inv.setItem(3, cmp);


}
}
