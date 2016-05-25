package net.minegusta.mggods.main;

import net.minegusta.mggods.listeners.GodsListener;
import org.bukkit.event.Listener;

public enum Listeners {

	GODSLISTENER(new GodsListener());

	private Listener listener;

	Listeners(Listener listener)
	{
		this.listener = listener;
	}

	public Listener getListener()
	{
		return listener;
	}
}
