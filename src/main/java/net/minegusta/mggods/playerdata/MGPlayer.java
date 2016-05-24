package net.minegusta.mggods.playerdata;

import java.util.Optional;

public class MGPlayer {

	private String uuid;
	private Optional<Marriage> marriage = null;
	private long nextPrayer = 0;

	public MGPlayer(String uuid, long lastPrayer)
	{
		this.uuid = uuid;
		this.marriage = Optional.empty();
		this.nextPrayer = lastPrayer;
	}

	public MGPlayer(String uuid, Marriage marriage, long lastPrayer)
	{
		this.uuid = uuid;
		this.marriage = Optional.of(marriage);
		this.nextPrayer = lastPrayer;
	}

	public long getNextPrayer() {
		return nextPrayer;
	}

	public void setLastPrayer() {
		this.nextPrayer = System.currentTimeMillis() + 64800000;
	}

	public Optional<Marriage> getMarriage() {
		return marriage;
	}

	public void setMarriage(Optional<Marriage> marriage) {
		this.marriage = marriage;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
