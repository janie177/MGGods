package net.minegusta.mggods.util;

import net.minegusta.mggods.playerdata.MGPlayer;
import net.minegusta.mggods.playerdata.PlayerData;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class ShrineCooldown {

	public static boolean canUseShrine(Player p)
	{
		//get from mgp
		MGPlayer mgp = PlayerData.getPlayer(p);
		return System.currentTimeMillis() > mgp.getNextPrayer();
	}

	public static long getTimeLeft(Player p)
	{
		//saved in mgp
		MGPlayer mgp = PlayerData.getPlayer(p);
		return TimeUnit.MILLISECONDS.toMinutes(mgp.getNextPrayer() - System.currentTimeMillis());
	}

	public static void setCooldown(Player p)
	{
		//save to mgp
		MGPlayer mgp = PlayerData.getPlayer(p);
		mgp.setLastPrayer();
	}
}
