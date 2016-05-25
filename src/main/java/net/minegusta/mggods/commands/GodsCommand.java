package net.minegusta.mggods.commands;

import com.google.common.collect.Lists;
import com.minegusta.mgracesredone.util.WorldCheck;
import net.minegusta.mggods.gods.AbstractGod;
import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.gods.shrineblocks.ShrineBlock;
import net.minegusta.mggods.main.GodsPlugin;
import net.minegusta.mggods.playerdata.MGPlayer;
import net.minegusta.mggods.playerdata.PlayerData;
import net.minegusta.mggods.util.ChatUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GodsCommand implements CommandExecutor {

	private static final String[] help = new String[]{
			ChatColor.YELLOW + "/Gods Power" + ChatColor.GRAY + " - " + ChatColor.ITALIC + "Show all gods and their power.",
			ChatColor.YELLOW + "/Gods Info <AbstractGod>" + ChatColor.GRAY + " - " + ChatColor.ITALIC + "Show info about the specified god.",
			ChatColor.YELLOW + "/Gods Info" + ChatColor.GRAY + " - " + ChatColor.ITALIC + "Show info about your god.",
			ChatColor.YELLOW + "/Gods List" + ChatColor.GRAY + " - " + ChatColor.ITALIC + "List all gods.",
			ChatColor.YELLOW + "/Gods Players" + ChatColor.GRAY + " - " + ChatColor.ITALIC + "Show online players stats."
	};

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player) sender;

			if(!WorldCheck.isEnabled(p.getWorld()))
			{
				ChatUtil.sendString(p, "Race gods are not enabled in this world.");
				return true;
			}

			God god = GodsPlugin.getGodForPlayer(p);

			if(args.length < 1)
			{
				ChatUtil.sendList(p, help);
				return true;
			}

			if(args.length == 1)
			{
				MGPlayer mgp = PlayerData.getPlayer(p);
				if(args[0].equalsIgnoreCase("info"))
				{
					List<String> sendHelp = Lists.newArrayList(ChatColor.GOLD + "Your race follows the god " + god.getGod().getName() + ChatColor.GOLD + ".", god.getGod().getName() +  ChatColor.LIGHT_PURPLE + " has " + ChatColor.YELLOW + god.getGod().getPower() + ChatColor.LIGHT_PURPLE + " power.", ChatColor.YELLOW + "You earned your god " + ChatColor.AQUA + mgp.getPowerEarned() + ChatColor.YELLOW + " power in total.");
					for(String s : god.getGod().getDescription())
					{
						sendHelp.add(ChatColor.GRAY + s);
					}
					sendHelp.add(ChatColor.YELLOW + "The following blocks can be used on shrines.");
					for(ShrineBlock s : god.getGod().getShrineBlocks())
					{
						sendHelp.add(ChatColor.GRAY + "- " + s.getMaterial().name() + " - Value: " + s.getValue());
					}
					sendHelp.add(ChatColor.YELLOW + "The bigger the value of the shrine, the bigger your reward.");
					sendHelp.add(ChatColor.LIGHT_PURPLE + "Place a sign on your shrine with your god's name on it.");
					sendHelp.add(ChatColor.LIGHT_PURPLE + "Right click it once per day to pray and gain rewards.");
					sendHelp.add(ChatColor.LIGHT_PURPLE + "Shrines only work when your god has most power.");
					sendHelp.add(ChatColor.LIGHT_PURPLE + "Blocks in a radius of 8 around your shrine are counted.");

					ChatUtil.sendList(p, sendHelp.toArray(new String[sendHelp.size()]));
					return true;
				}
				if(args[0].equalsIgnoreCase("players"))
				{
					List<String> sendHelp = Lists.newArrayList(ChatColor.YELLOW + "..-[" + ChatColor.GOLD + " Player" + ChatColor.DARK_GRAY + "   |   " + ChatColor.DARK_PURPLE + "Power Earned " + ChatColor.YELLOW + "]-..");
					PlayerData.getMGPlayers().stream().forEach(mp ->
					{
						if(mp.getGod() == mgp.getGod())
						{
							sendHelp.add(ChatColor.GRAY + " - " + mp.getName() + ChatColor.DARK_GRAY + " | " + ChatColor.DARK_PURPLE + mp.getPowerEarned());
						}
					});
					ChatUtil.sendList(p, sendHelp.toArray(new String[sendHelp.size()]));
					return true;
				}
				if(args[0].equalsIgnoreCase("power"))
				{
					List<String> sendHelp = Lists.newArrayList(ChatColor.GOLD + "Your race follows the god " + god.getGod().getName() + ChatColor.GOLD + ".");
					for(God g : God.values())
					{
						sendHelp.add(g.getGod().getName() +  ChatColor.LIGHT_PURPLE + " has " + ChatColor.YELLOW + g.getGod().getPower() + ChatColor.LIGHT_PURPLE + " power.");
					}
					ChatUtil.sendList(p, sendHelp.toArray(new String[sendHelp.size()]));
					return true;
				}
				if(args[0].equalsIgnoreCase("list"))
				{
					int i = 1;
					String[] gods = new String[God.values().length + 1];
					gods[0] = ChatColor.YELLOW + "There are currently the following gods:";
					for(God g : God.values())
					{
						gods[i] = ChatColor.GRAY + " - " + g.getGod().getName();
					}

					ChatUtil.sendList(p, gods);
					return true;
				}

			}
			else if(args.length == 2)
			{
				if(args[0].equalsIgnoreCase("info"))
				{
					String godString = args[1].toUpperCase();
					try {
						AbstractGod g = God.valueOf(godString).getGod();
						List<String> sendHelp = Lists.newArrayList(ChatColor.GOLD + "Showing info about the god " + g.getName() + ChatColor.GOLD + ".", g.getName() +  ChatColor.LIGHT_PURPLE + " has " + ChatColor.YELLOW + g.getPower() + ChatColor.LIGHT_PURPLE + " power.");
						for(String s : g.getDescription())
						{
							sendHelp.add(ChatColor.GRAY + s);
						}

						ChatUtil.sendList(p, sendHelp.toArray(new String[sendHelp.size()]));

					} catch (Exception ignored)
					{
						int i = 1;
						String[] gods = new String[God.values().length + 1];
						gods[0] = ChatColor.YELLOW + "There are currently the following gods:";
						for(God g : God.values())
						{
							gods[i] = ChatColor.GRAY + " - " + g.getGod().getName();
						}

						ChatUtil.sendList(p, gods);
					}
					return true;
				}
			}


			ChatUtil.sendList(p, help);
		}
		return true;
	}
}
