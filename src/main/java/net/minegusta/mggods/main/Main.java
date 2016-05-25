package net.minegusta.mggods.main;

import net.minegusta.mggods.config.ConfigManager;
import net.minegusta.mggods.config.PlayerFileManager;
import net.minegusta.mggods.playerdata.PlayerData;
import net.minegusta.mggods.tasks.SaveTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Plugin plugin;

	@Override
	public void onEnable()
	{
		//Initialize the plugin
		plugin = this;

		//Create the config if it's not there
		saveDefaultConfig();

		//Load all commands
		for(Commands command : Commands.values())
		{
			getCommand(command.getCommandName()).setExecutor(command.getExecutor());
		}

		//Load all listeners
		for(Listeners listener : Listeners.values())
		{
			getServer().getPluginManager().registerEvents(listener.getListener(), this);
		}

		//Load power for gods
		ConfigManager.loadGodsPower();

		//Tasks
		SaveTask.start();

		Bukkit.getOnlinePlayers().stream().forEach(p -> PlayerData.addPlayer(p, PlayerFileManager.loadPlayerFromConfig(p)));
	}

	@Override
	public void onDisable()
	{
		SaveTask.saveAll();

		//Tasks
		SaveTask.stop();
	}

	public static Plugin getPlugin()
	{
		return plugin;
	}
}
