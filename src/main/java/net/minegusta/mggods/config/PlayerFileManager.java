package net.minegusta.mggods.config;

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
				conf.getLong("last-prayer", 0)
		);

		return mgp;
	}

	public static void saveMGPlayer(MGPlayer mgp)
	{
		String uuid = mgp.getUuid();

		FileConfiguration conf = FileManager.getFile(uuid);
		conf.set("last-prayer", mgp.getNextPrayer());
		conf.set("marriage-id", mgp.getMarriage().isPresent() ? mgp.getMarriage().get() : null);

		FileManager.save(uuid, conf);
	}
}
