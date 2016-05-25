package net.minegusta.mggods.playerdata;

import net.minegusta.mggods.gods.God;

public class MGPlayer {

	private String uuid;
	private long nextPrayer = 0;
	private String name = "";
	private long powerEarned = 0;
	private God god;

	public MGPlayer(String uuid, String name, God god, long lastPrayer, long powerEarned)
	{
		this.god = god;
		this.uuid = uuid;
		this.name = name;
		this.nextPrayer = lastPrayer;
		this.powerEarned = powerEarned;
	}

	public long getNextPrayer() {
		return nextPrayer;
	}

	public void setLastPrayer() {
		this.nextPrayer = System.currentTimeMillis() + 3600000;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public long getPowerEarned() {
		return powerEarned;
	}

	public void setPowerEarned(long powerEarned) {
		this.powerEarned = powerEarned;
	}

	public void addPowerEarned(long powerEarned) {
		setPowerEarned(getPowerEarned() + powerEarned);
	}

	public God getGod()
	{
		return god;
	}

	public void setGod(God god)
	{
		this.god = god;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
