package net.minegusta.mggods.tasks;

import net.minegusta.mggods.config.ConfigManager;
import net.minegusta.mggods.config.PlayerFileManager;
import net.minegusta.mggods.main.Main;
import net.minegusta.mggods.playerdata.PlayerData;
import org.bukkit.Bukkit;

public class SaveTask {
	private static int id = -1;

	public static void start()
	{
		id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), SaveTask::saveAll, 20 * 300, 20 * 300);
	}

	public static void stop()
	{
		if(id != -1)
		{
			Bukkit.getScheduler().cancelTask(id);
		}
	}

	public static void saveAll()
	{
		ConfigManager.saveGodsPower();
		PlayerData.getMGPlayers().stream().forEach(PlayerFileManager::saveMGPlayer);
	}
}
