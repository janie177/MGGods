package net.minegusta.mggods.config;

import net.minegusta.mggods.main.GodsPlugin;
import net.minegusta.mggods.playerdata.MGPlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class PlayerFileManager {

	public static MGPlayer loadPlayerFromConfig(Player p)
	{
		String uuid = p.getUniqueId().toString();

		FileConfiguration conf = FileManager.getFile(uuid);
		MGPlayer mgp = new MGPlayer(
				uuid,
				p.getName(),
				GodsPlugin.getGodForPlayer(p),
				conf.getLong("last-prayer", 0),
				conf.getLong("power-earned", 0)
		);

		return mgp;
	}

	public static void saveMGPlayer(MGPlayer mgp)
	{
		String uuid = mgp.getUuid();

		FileConfiguration conf = FileManager.getFile(uuid);
		conf.set("name", mgp.getName());
		conf.set("last-prayer", mgp.getNextPrayer());
		conf.set("power-earned", mgp.getPowerEarned());

		FileManager.save(uuid, conf);
	}
}
