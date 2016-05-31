package net.minegusta.mggods.gods.implemented;

import com.google.common.collect.Lists;
import com.minegusta.mgracesredone.races.RaceType;
import net.minegusta.mggods.gods.AbstractGod;
import net.minegusta.mggods.gods.shrineblocks.ShrineBlock;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.List;

public class Silas extends AbstractGod {
	@Override
	public String getName() {
		return ChatColor.YELLOW + "Silas";
	}

	@Override
	public String[] getDescription() {
		return new String[]{
				"Silas is the god of all that is good.",
				"His followers are tasked with purging the land",
				"of unholy races and humans. He gains strength when they are slain.",
				"Though peace is his intention, it can only be achieved",
				"with the sword. His enemy is the cruel Phenax after all."
		};
	}

	private static final List<RaceType> races = Lists.newArrayList(RaceType.ELF, RaceType.DWARF, RaceType.AURORA, RaceType.ANGEL);

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
			ShrineBlock.create(Material.GLOWSTONE, (byte)0, 6)
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
				return ChatColor.AQUA + "-=-=-=-=-";
			case 1:
				return getName();
			case 2:
				return ChatColor.AQUA + "" + ChatColor.BOLD + "ALTAR";
			case 3:
				return ChatColor.AQUA + "-=-=-=-=-";
		}
		return "";
	}


	private static String[] positive = new String[]{
			"We are winning this war.",
			"Let our light cleanse this land.",
			"Peace is upon us.",
			"Pray and I shall give back.",
			"I will reward you for praying my child.",
			"Soon there will be only light.",
			"Pray for all that is good.",
			"Pity those that oppose us."
	};

	@Override
	public String[] getPositiveSpeech() {
		return positive;
	}

	@Override
	public String getChatTag() {
		return ChatColor.GOLD + "[" + getName() + ChatColor.GOLD + "]";
	}

	private static String[] negative = new String[]{
			"I'm afraid we are losing.",
			"Go and fetch me more power my child.",
			"You have to believe harder.",
			"Fulfill your duty to me and pray.",
			"Do not fear my child, we shall overcome this.",
			"Believe in me and good things will happen.",
			"Do not be afraid. The light shall cleanse.",
			"Better times are ahead of us.",
			"We need more shrines to rule again.",
			"Build me more altars my child.",
			"Have faith in me."
	};

	@Override
	public String[] getNegativeSpeech() {
		return negative;
	}


	private static String[] playerPositive = new String[]{
			"You are a loyal follower.",
			"Spread the word of our religion.",
			"You will be rewarded.",
			"You are doing well. Keep on praying.",
			"Tell more people about our cause.",
			"Embrace the light my child."
	};

	@Override
	public String[] getPlayerPositiveSpeech() {
		return  playerPositive;
	}
}
