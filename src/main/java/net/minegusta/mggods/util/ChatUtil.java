package net.minegusta.mggods.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {
	public static void sendString(Player p, String s)
	{
		p.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "GODS" + ChatColor.DARK_PURPLE + "] " + ChatColor.YELLOW + s);
	}

	public static void sendList(Player p, String[] strings)
	{
		p.sendMessage(ChatColor.YELLOW + "______." + ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "GODS" + ChatColor.DARK_PURPLE + "]" + ChatColor.YELLOW + ".______");
		for(String s : strings)
		{
			p.sendMessage(" " + s);
		}
	}
}
