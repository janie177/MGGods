package net.minegusta.mggods.main;

import com.minegusta.mgracesredone.main.Races;
import com.minegusta.mgracesredone.races.RaceType;
import net.minegusta.mggods.gods.God;
import org.bukkit.entity.Player;

public class GodsPlugin {

	public static God getGodForPlayer(Player p)
	{
		for(God g : God.values())
		{
			RaceType r = Races.getRace(p);
			if(g.getGod().getRaces().contains(r))
			{
				return g;
			}
		}
		return God.TALOS;
	}

	public static God getLeadingGod()
	{
		int maxPower = 0;
		God leader = God.TALOS;
		for(God g : God.values())
		{
			if(g.getGod().getPower() > maxPower)
			{
				leader = g;
				maxPower = g.getGod().getPower();
			}
		}
		return leader;
	}
}
