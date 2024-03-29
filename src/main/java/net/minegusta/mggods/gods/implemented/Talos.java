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

	private static List<Material> rewards = Lists.newArrayList(Material.DIAMOND_SWORD, Material.DIAMOND_ORE, Material.DIAMOND, Material.EMERALD, Material.GOLD_BLOCK, Material.GOLD_INGOT, Material.IRON_INGOT, Material.IRON_CHESTPLATE, Material.LAVA_BUCKET, Material.COAL_BLOCK, Material.EMERALD_BLOCK, Material.IRON_INGOT, Material.LAVA_BUCKET, Material.GREEN_RECORD, Material.JUKEBOX, Material.ENDER_CHEST, Material.ENCHANTMENT_TABLE, Material.DIAMOND, Material.GOLD_INGOT, Material.GOLD_ORE, Material.IRON_ORE, Material.DIRT, Material.GRASS, Material.GRASS_PATH, Material.OBSIDIAN, Material.STONE, Material.IRON_AXE, Material.IRON_INGOT, Material.IRON_BOOTS, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_HELMET, Material.IRON_SWORD, Material.WOOD, Material.LOG, Material.LEAVES, Material.WATER_BUCKET);
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

	private static String[] positive = new String[]{
			"We are winning this war!",
			"We are ruling the land!",
			"Keep slaying those who are against us.",
			"Slay in my cause, and I will reward you.",
			"I once walked among you. Not as god, but as man!",
			"Build more shrines in my cause!",
			"Keep praying and we will remain undefeated.",
			"We are prosperous.",
			"The human race shall overcome!",
			"Humans are the only pure race."
	};

	@Override
	public String[] getPositiveSpeech() {
		return positive;
	}

	@Override
	public String getChatTag() {
		return ChatColor.DARK_GRAY + "[" + getName() + ChatColor.DARK_GRAY + "]";
	}

	private static String[] negative = new String[]{
			"Bear the sword and shield. Crusade in my cause.",
			"We are losing this war.",
			"Stick together humans, and we will rule once more!",
			"Pick up the sword and conquer.",
			"Do not fear death. Fear a life of slavery.",
			"Today is a black day for us.",
			"The future may be better. Fight for it.",
			"We have to fight for our freedom.",
			"Pick up the sword and remain a free race.",
			"Do not lose faith. Faith keeps us alive.",
			"We need more power."
	};

	@Override
	public String[] getNegativeSpeech() {
		return negative;
	}


	private static String[] playerPositive = new String[]{
			"You do well. Fight for me!",
			"Conquer land and make settlements!",
			"Become immortal. Gain more followers!",
			"You are a loyal follower.",
			"I will answer your prayers!",
			"Make shrines for our cause.",
			"You are a brave warrior!",
			"You will be rewarded in the afterlife.",
			"You do not know fear. I am proud."
	};

	@Override
	public String[] getPlayerPositiveSpeech() {
		return  playerPositive;
	}
}
