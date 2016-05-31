package net.minegusta.mggods.util;

import net.minegusta.mggods.gods.God;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {
	public static void sendString(Player p, String s)
	{
		p.sendMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "GODS" + ChatColor.DARK_PURPLE + "] " + ChatColor.YELLOW + s);
	}

	public static void sendList(Player p, String[] strings)
	{
		p.sendMessage(ChatColor.YELLOW + "------------." + ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "GODS" + ChatColor.DARK_PURPLE + "]" + ChatColor.YELLOW + ".------------");
		for(String s : strings)
		{
			p.sendMessage(" " + s);
		}
	}

	public static void sendMessageAsGod(God god, Player player, String message)
	{
		player.sendMessage(god.getGod().getChatTag() + ChatColor.GRAY + " " + ChatColor.ITALIC + " " + message);
	}
}
