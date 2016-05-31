package net.minegusta.mggods.tasks;

import com.minegusta.mgracesredone.util.WorldCheck;
import net.minegusta.mggods.dictionary.Dictionary;
import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.main.Main;
import net.minegusta.mggods.playerdata.MGPlayer;
import net.minegusta.mggods.playerdata.PlayerData;
import net.minegusta.mggods.util.ChatUtil;
import net.minegusta.mggods.util.RandomUtil;
import org.bukkit.Bukkit;

public class GodsTalkTask {
	private static int ID = -1;

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
			Bukkit.getOnlinePlayers().stream().forEach(p ->
			{
				if(RandomUtil.fiftyfifty())
				{
					if(WorldCheck.isEnabled(p.getWorld()))
					{
						MGPlayer mgp = PlayerData.getPlayer(p);
						God god = mgp.getGod();
						ChatUtil.sendMessageAsGod(god, p, Dictionary.getMessageForGod(god, mgp));
					}
				}
			});
		}, 20 * 180, 20 * 180);
	}
}
