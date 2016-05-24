package net.minegusta.mggods.playerdata;

import com.google.common.collect.Maps;
import net.minegusta.mggods.config.PlayerFileManager;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

public class PlayerData {
	private static ConcurrentMap<String, MGPlayer> players = Maps.newConcurrentMap();

	public static void addPlayer(Player p, MGPlayer mgp)
	{
		players.put(p.getUniqueId().toString(), mgp);
	}

	public static MGPlayer getPlayer(Player p)
	{
		if(!players.containsKey(p.getUniqueId().toString())) PlayerFileManager.loadPlayerFromConfig(p);
		return players.get(p.getUniqueId().toString());
	}

	public static void removePlayer(Player p)
	{
		if(players.containsKey(p.getUniqueId().toString()))players.remove(p.getUniqueId().toString());
	}

	public static Collection<MGPlayer> getMGPlayers()
	{
		return players.values();
	}
}
