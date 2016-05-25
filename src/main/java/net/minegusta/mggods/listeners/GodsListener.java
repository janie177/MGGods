package net.minegusta.mggods.listeners;

import com.minegusta.mgracesredone.events.RaceChangeEvent;
import com.minegusta.mgracesredone.races.RaceType;
import com.minegusta.mgracesredone.util.WorldCheck;
import net.minegusta.mggods.config.PlayerFileManager;
import net.minegusta.mggods.gods.God;
import net.minegusta.mggods.main.GodsPlugin;
import net.minegusta.mggods.playerdata.MGPlayer;
import net.minegusta.mggods.playerdata.PlayerData;
import net.minegusta.mggods.util.ChatUtil;
import net.minegusta.mggods.util.ShrineCooldown;
import net.minegusta.mggods.util.ShrineUtil;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;

public class GodsListener implements Listener {

	//Listen for race change
	@EventHandler
	public void onRaceChange(RaceChangeEvent e)
	{
		MGPlayer mgp = PlayerData.getPlayer(e.getPlayer());
		mgp.setPowerEarned(0);
		try {
			RaceType race = RaceType.valueOf(e.to());
			God god = GodsPlugin.getGodForRace(race);
			mgp.setGod(god);
		} catch (Exception ignored){}
	}

	//Load player
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		PlayerData.addPlayer(e.getPlayer(), PlayerFileManager.loadPlayerFromConfig(e.getPlayer()));
	}


	//Remove player
	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		PlayerFileManager.saveMGPlayer(PlayerData.getPlayer(e.getPlayer()));
		PlayerData.removePlayer(e.getPlayer());
	}

	//Add and remove gods power on killing
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e)
	{
		Player p = e.getEntity();
		if(!WorldCheck.isEnabled(p.getWorld()))return;

		God god = GodsPlugin.getGodForPlayer(p);
		MGPlayer mgp = PlayerData.getPlayer(p);

		if(p.getLastDamageCause() instanceof EntityDamageByEntityEvent)
		{
			EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) p.getLastDamageCause();
			if(damageEvent.getDamager() instanceof Player)
			{
				Player damager = (Player) damageEvent.getDamager();
				MGPlayer damagerMGP = PlayerData.getPlayer(damager);
				God damagerGod = GodsPlugin.getGodForPlayer(damager);
				if(damagerGod != god)
				{
					damagerGod.getGod().addPower(5, damagerMGP);
					ChatUtil.sendString(damager, "Your god gained 5 power because you killed " + p.getName() + ".");
					god.getGod().removePower(4, mgp);
					ChatUtil.sendString(p, "Your god lost 4 power because you died to another god's follower.");
				}
			}
			else if(damageEvent.getDamager() instanceof Projectile && ((Projectile) damageEvent.getDamager()).getShooter() instanceof Player)
			{
				Player damager = (Player) ((Projectile) damageEvent.getDamager()).getShooter();
				God damagerGod = GodsPlugin.getGodForPlayer(damager);
				MGPlayer damagerMGP = PlayerData.getPlayer(damager);
				if(damagerGod != god)
				{
					damagerGod.getGod().addPower(5, damagerMGP);
					ChatUtil.sendString(damager, "Your god gained 5 power because you killed " + p.getName() + ".");
					god.getGod().removePower(4, mgp);
					ChatUtil.sendString(p, "Your god lost 4 power because you died to another god's follower.");
				}
			}
		}
		else
		{
			ChatUtil.sendString(p, "Your god lost 2 power because you died.");
			god.getGod().removePower(2, mgp);
		}
	}


	//Listen for shrines, award rewards, add cooldowns and apply god power.
	@EventHandler
	public void onShrineInteract(PlayerInteractEvent e)
	{
		if(e.getHand() != EquipmentSlot.HAND) return;
		if(!WorldCheck.isEnabled(e.getPlayer().getWorld()))return;

		Player p = e.getPlayer();
		God god = GodsPlugin.getGodForPlayer(p);

		if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Block b = e.getClickedBlock();
			if(b.getState() instanceof Sign)
			{
				Sign sign = (Sign) b.getState();

				if(ShrineUtil.isShrine(sign, p)) {

					if(ShrineCooldown.canUseShrine(p))
					{
						if(god == GodsPlugin.getLeadingGod())
						{
							int value = ShrineUtil.getShrineValue(b.getLocation(), god.getGod().getShrineBlocks());
							ShrineCooldown.setCooldown(p);
							ShrineUtil.rewardPlayer(p, god, value);
						}
						else
						{
							ChatUtil.sendList(p, new String[]
									{
											ChatColor.YELLOW + "You pray, but gain no rewards.",
											ChatColor.GRAY + "In order to gain rewards, your god",
											ChatColor.GRAY + "need to have the most power of all.",
											ChatColor.LIGHT_PURPLE + "Your god gained 2 power from your prayer."
									});
							god.getGod().addPower(2, PlayerData.getPlayer(p));
						}
					}
					else
					{
						ChatUtil.sendList(p, new String[]{
								ChatColor.YELLOW + "You cannot pray to your god yet.",
								ChatColor.GRAY + "You have to wait another " + ShrineCooldown.getTimeLeft(p) + " minutes before you can pray."
						});
					}
				}
			}
		}
	}


	//Set signs to be nice god signs
	@EventHandler
	public void onSignChange(SignChangeEvent e)
	{
		if(!WorldCheck.isEnabled(e.getPlayer().getWorld()))return;

		int empty = 0;
		boolean god = false;
		God chosen = null;
		MGPlayer mgp = PlayerData.getPlayer(e.getPlayer());

		for(String s : e.getLines()) {
			if (s == null || s.isEmpty()) {
				empty++;
			} else
			{
				God g = mgp.getGod();
				if(g.name().equalsIgnoreCase(s))
				{
					god = true;
				}
			}
		}

		if(empty == 3 && god)
		{
			for(int i = 0; i < 4; i++)
			{
				e.setLine(i, chosen.getGod().getShrineLine(i));
			}
			ChatUtil.sendString(e.getPlayer(), ChatColor.YELLOW + "You created a shrine for your god.");
		}
	}
}
