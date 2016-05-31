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
				"reign the world. Slaying non-allied gives him strength."
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

	private static String[] positive = new String[]{
			"WE ARE WINNING THIS WAR. THE WORLD IS OURS!",
			"WE WILL FEAST ON THE BONES OF OUR ENEMIES TONIGHT!",
			"THE FALSE GODS HAVE FALLEN.",
			"YOUR PRAYERS WILL BE ANSWERED!",
			"KEEP PRAYING AND I SHALL REWARD YOU!",
			"NO ENEMY STANDS A CHANCE.",
			"ENSLAVE THOSE WHO OPPOSE US!",
			"EMBRACE THE SHADOW I CAST UPON THE LAND!"
	};

	@Override
	public String[] getPositiveSpeech() {
		return positive;
	}

	@Override
	public String getChatTag() {
		return ChatColor.BLACK + "[" + getName() + ChatColor.BLACK + "]";
	}

	private static String[] negative = new String[]{
			"YOU WORTHLESS FOLLOWER! GAIN ME POWER!",
			"PRAY TO ME OR FEEL MY WRATH!",
			"YOU ARE AN UNBELIEVER!",
			"STOP DISAPPOINTING ME!",
			"HEAR MY COMMANDS AND SLAY THE INFIDELS!",
			"DO NOT QUESTION MY WORD!",
			"YOU ARE USELESS!",
			"WHY WONT YOU ANSWER MY REQUEST!",
			"SUPPLY ME WITH POWER OR PERISH!",
			"YOU ARE UNWORTHY OF MY COMMAND!",
			"PRAY TO ME OR I SHALL STRIKE YOU DOWN!",
			"YOU WORTHLESS UNBELIEVER!"
	};

	@Override
	public String[] getNegativeSpeech() {
		return negative;
	}

	private static String[] playerPositive = new String[]{
			"YOU DO WELL, BUT I REQUIRE MORE POWER!",
			"SLAY THE UNBELIEVERS AND PRAY TO MY CAUSE!",
			"I REQUIRE MORE POWER!",
			"LET THE BLOOD OF OUR ENEMIES FLOW!",
			"I NEED MORE POWER!",
			"FEED ME YOUR PRAYERS!",
			"I GROW STRONGER, SOON WE SHALL RULE!",
			"I WILL RISE TO POWER!",
			"PRAY TO ME CHILD, AND WE SHALL BE INVINCIBLE!",
			"SPREAD DEATH ACROSS THE LAND!",
			"DO NOT HESITATE TO SLAY THOSE WHO OPPOSE ME!",
			"BELIEVE IN ME AND I SHALL RULE!"
	};

	@Override
	public String[] getPlayerPositiveSpeech() {
		return  playerPositive;
	}
}
