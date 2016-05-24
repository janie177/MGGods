package net.minegusta.mggods.gods.implemented;

import com.google.common.collect.Lists;
import com.minegusta.mgracesredone.races.RaceType;
import net.minegusta.mggods.gods.AbstractGod;
import net.minegusta.mggods.gods.shrineblocks.ShrineBlock;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.List;

public class Talos extends AbstractGod {
	@Override
	public String getName() {
		return ChatColor.GRAY + "Talos";
	}

	@Override
	public String[] getDescription() {
		return new String[]{
				"Talos is the god of men. Some say he is not even a deity.",
				"Men interpret his ways differently and thus he gains",
				"power from any race being slain.",
				"He is weakened whenever a human dies."
		};
	}

	private static List<RaceType> races = Lists.newArrayList(RaceType.HUMAN);

	@Override
	public List<RaceType> getRaces() {
		return races;
	}

	private static List<ShrineBlock> shrineBlocks = Lists.newArrayList(
			ShrineBlock.create(Material.DIAMOND_BLOCK, (byte)0, 15),
			ShrineBlock.create(Material.EMERALD_BLOCK, (byte)0, 15),
			ShrineBlock.create(Material.LAPIS_BLOCK, (byte)0, 6),
			ShrineBlock.create(Material.IRON_BLOCK, (byte)0, 7),
			ShrineBlock.create(Material.GOLD_BLOCK, (byte)0, 9)
	);

	@Override
	public List<ShrineBlock> getShrineBlocks() {
		return shrineBlocks;
	}

	private static List<Material> rewards = Lists.newArrayList(Material.DIAMOND_SWORD, Material.DIAMOND_ORE, Material.DIAMOND, Material.EMERALD, Material.GOLD_BLOCK, Material.GOLD_INGOT, Material.IRON_INGOT, Material.IRON_CHESTPLATE, Material.LAVA_BUCKET, Material.COAL_BLOCK, Material.EMERALD_BLOCK, Material.IRON_INGOT, Material.LAVA_BUCKET, Material.GREEN_RECORD, Material.JUKEBOX, Material.ENDER_CHEST, Material.ENCHANTMENT_TABLE, Material.DIAMOND, Material.GOLD_INGOT, Material.GOLD_ORE, Material.IRON_ORE);

	@Override
	public List<Material> getRandomRewards() {
		return rewards;
	}

	@Override
	public String getShrineLine(int line) {
		switch (line)
		{
			case 0:
				return ChatColor.WHITE + "-=-=-=-=-";
			case 1:
				return getName();
			case 2:
				return ChatColor.WHITE + "" + ChatColor.BOLD + "ALTAR";
			case 3:
				return ChatColor.WHITE + "-=-=-=-=-";
		}
		return "";
	}
}
