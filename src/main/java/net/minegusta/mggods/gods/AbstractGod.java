package net.minegusta.mggods.gods;

import com.minegusta.mgracesredone.races.RaceType;
import net.minegusta.mggods.gods.shrineblocks.ShrineBlock;
import net.minegusta.mggods.playerdata.MGPlayer;
import org.bukkit.Material;

import java.util.List;

public abstract class AbstractGod {

	private int power;

	public abstract String getName();

	public abstract String[] getDescription();

	public abstract List<RaceType> getRaces();

	public abstract List<ShrineBlock> getShrineBlocks();

	public abstract List<Material> getRandomRewards();

	public abstract String getShrineLine(int line);

	public void addPower(int added, MGPlayer mgp)
	{
		this.power += added;
		mgp.addPowerEarned(added);
	}

	public void removePower(int removed, MGPlayer mgp)
	{
		power -= removed;
		if(power < 0) power = 0;
		mgp.addPowerEarned(removed);
	}

	public int getPower()
	{
		return power;
	}

	public void setPower(int power)
	{
		this.power = power;
	}
}
