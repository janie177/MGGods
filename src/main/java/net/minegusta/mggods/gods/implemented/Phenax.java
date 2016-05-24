package net.minegusta.mggods.gods.implemented;

import com.google.common.collect.Lists;
import com.minegusta.mgracesredone.races.RaceType;
import net.minegusta.mggods.gods.AbstractGod;
import net.minegusta.mggods.gods.shrineblocks.ShrineBlock;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.List;

public class Phenax extends AbstractGod {
	@Override
	public String getName() {
		return ChatColor.RED + "Phenax";
	}

	@Override
	public String[] getDescription() {
		return new String[]{
				"Phenax is the god of evil.",
				"He is followed by the dark races of the world.",
				"War, Cruelty and pain are his domains as he seeks to",
				"reign the world. Slaying holy races gives him strength."
		};
	}

	private static List<RaceType> races = Lists.newArrayList(RaceType.ENDERBORN, RaceType.DEMON, RaceType.VAMPIRE, RaceType.WEREWOLF);

	@Override
	public List<RaceType> getRaces() {
		return races;
	}

	private static List<ShrineBlock> shrineBlocks = Lists.newArrayList(
			ShrineBlock.create(Material.DIAMOND_BLOCK, (byte)0, 15),
			ShrineBlock.create(Material.EMERALD_BLOCK, (byte)0, 15),
			ShrineBlock.create(Material.LAPIS_BLOCK, (byte)0, 6),
			ShrineBlock.create(Material.IRON_BLOCK, (byte)0, 7),
			ShrineBlock.create(Material.GOLD_BLOCK, (byte)0, 9),
			ShrineBlock.create(Material.REDSTONE_BLOCK, (byte)0, 6),
			ShrineBlock.create(Material.OBSIDIAN, (byte)0, 6),
			ShrineBlock.create(Material.COAL_BLOCK, (byte)0, 6)
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
				return ChatColor.DARK_RED + "-=-=-=-=-";
			case 1:
				return getName();
			case 2:
				return ChatColor.DARK_RED + "" + ChatColor.BOLD + "ALTAR";
			case 3:
				return ChatColor.DARK_RED + "-=-=-=-=-";
		}
		return "";
	}
}
