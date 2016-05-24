package net.minegusta.mggods.main;

import net.minegusta.mggods.commands.GodsCommand;
import org.bukkit.command.CommandExecutor;

public enum Commands {

	GODS("gods", new GodsCommand());

	private CommandExecutor executor;
	private String commandName;

	Commands(String command, CommandExecutor executor)
	{
		this.commandName = command;
		this.executor = executor;
	}

	public String getCommandName()
	{
		return commandName;
	}

	public CommandExecutor getExecutor()
	{
		return executor;
	}
}
