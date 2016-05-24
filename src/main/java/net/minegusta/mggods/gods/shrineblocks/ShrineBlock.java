package net.minegusta.mggods.gods.shrineblocks;

import org.bukkit.Material;

public class ShrineBlock {

	private Material material;
	private byte data;
	private int value;

	private ShrineBlock(Material material, byte data, int value)
	{
		this.material = material;
		this.data = data;
		this.value = value;
	}

	public static ShrineBlock create(Material material, byte data, int value)
	{
		return new ShrineBlock(material, data, value);
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public byte getData() {
		return data;
	}

	public void setData(byte data) {
		this.data = data;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
