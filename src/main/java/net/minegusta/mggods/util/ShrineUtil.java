package net.minegusta.mggods.util;

import com.minegusta.mgracesredone.util.RandomUtil;
import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.gods.shrineblocks.ShrineBlock;
import net.minegusta.mggods.main.GodsPlugin;
import net.minegusta.mggods.playerdata.MGPlayer;
import net.minegusta.mggods.playerdata.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ShrineUtil {

	public static int getShrineValue(Location l, List<ShrineBlock> blocks)
	{
		int total = 0;
		for(int x = -8; x < 9; x++)
		{
			for(int y = -8; y < 9; y++)
			{
				for(int z = -8; z < 9; z++)
				{
					Block b = l.getBlock().getRelative(x, y, z);
					for(ShrineBlock sb : blocks)
					{
						if(b.getType() == sb.getMaterial() && b.getData() == sb.getData())
						{
							total = total + sb.getValue();
						}
					}
				}
			}
		}

		return total;
	}

	public static boolean isShrine(Sign s, Player p) {
		String godName = PlayerData.getPlayer(p).getGod().getGod().getName();
		return s.getLine(1).equalsIgnoreCase(godName);
	}

	public static void rewardPlayer(Player p, God god, int value)
	{
		MGPlayer mgp = PlayerData.getPlayer(p);

		if(mgp.getPowerEarned() < 0)
		{
			ChatUtil.sendList(p, new String[]{
					ChatColor.YELLOW + "You pray to your god, giving 1 extra power!",
					ChatColor.LIGHT_PURPLE + "Your power needs to be positive in order to gain rewards.",
					ChatColor.LIGHT_PURPLE + "Try to stay alive instead of dying so often!"
			});
			return;
		}

		int amount = value / 50;

		if(amount > 9) amount = 9;

		ChatUtil.sendList(p, new String[]{
				ChatColor.YELLOW + "You pray to your god, giving 2 extra power!",
				ChatColor.LIGHT_PURPLE + "Your shrine has a total value of: " + ChatColor.DARK_PURPLE + value + ChatColor.LIGHT_PURPLE + ".",
				ChatColor.LIGHT_PURPLE + "This means you will get: " + ChatColor.DARK_PURPLE + amount + ChatColor.LIGHT_PURPLE + " rewards.",
		});

		for(int i = 0; i < amount; i++)
		{
			List<Material> randomRewards = god.getGod().getRandomRewards();
			p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(randomRewards.get(RandomUtil.randomNumber(randomRewards.size() - 1)), 1));
			p.getWorld().spigot().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 0, 0, 1, 1, 1, 1, 10, 30);
		}

		god.getGod().addPower(2, PlayerData.getPlayer(p));

	}

}
