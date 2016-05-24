package net.minegusta.mggods.config;

import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.main.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

	public static FileConfiguration getConfig()
	{
		return Main.getPlugin().getConfig();
	}

	public static void save()
	{
		Main.getPlugin().saveConfig();
	}

	public static void saveGodsPower()
	{
		FileConfiguration conf = getConfig();

		for(God g : God.values())
		{
			conf.set(g.name(), g.getGod().getPower());
		}
		save();
	}

	public static void loadGodsPower()
	{
		FileConfiguration conf = getConfig();

		for(God g : God.values())
		{
			int power = conf.getInt(g.name(), 0);
			g.getGod().setPower(power);
		}
	}
}
