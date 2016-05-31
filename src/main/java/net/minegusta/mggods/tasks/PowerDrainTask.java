package net.minegusta.mggods.tasks;

import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.main.Main;
import net.minegusta.mggods.playerdata.PlayerData;
import org.bukkit.Bukkit;

public class PowerDrainTask {

	private static int ID = -1;
	private static int interval = 2;

	public static void stop()
	{
		if(ID != -1)
		{
			Bukkit.getScheduler().cancelTask(ID);
		}
	}

	public static void start()
	{
		ID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), ()->
		{
			for(God god : God.values())
			{
				god.getGod().removePower(1, null);
				if(interval > 1) PlayerData.getMGPlayers().stream().filter(mgp -> mgp.getPowerEarned() < 0).forEach(mgp -> mgp.addPowerEarned(1));
			}
			interval++;
			if(interval > 2)
			{
				interval = 1;
			}
		}, 20 * 900, 20 * 900);
	}
}
