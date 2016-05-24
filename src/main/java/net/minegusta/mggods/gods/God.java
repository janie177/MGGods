package net.minegusta.mggods.gods;

import net.minegusta.mggods.gods.implemented.Phenax;
import net.minegusta.mggods.gods.implemented.Silas;
import net.minegusta.mggods.gods.implemented.Talos;

public enum God {
	PHENAX(new Phenax()),
	TALOS(new Talos()),
	SILAS(new Silas());

	private AbstractGod god;

	God(AbstractGod god)
	{
		this.god = god;
	}

	public AbstractGod getGod()
	{
		return god;
	}
}
