package net.minegusta.mggods.util;

import java.util.Random;

public class RandomUtil {

	private static Random rand = new Random();

	public static boolean chance(int percentage) {
		return rand.nextInt(100) + 1 <= percentage;
	}

	public static boolean promillage(int promillage) {
		return rand.nextInt(1000) + 1 <= promillage;
	}

	public static boolean fiftyfifty() {
		return rand.nextBoolean();
	}

	public static int randomNumberNeverZero(int max) {
		if(max < 1) return 0;
		return rand.nextInt(max) + 1;
	}

	public static int randomNumberZeroIncludedMaxExcluded(int max)
	{
		if(max < 1) return 0;
		return rand.nextInt(max);
	}

	public static double randomDouble(double max, double min) {
		return min + (max - min) * rand.nextDouble();
	}
}
