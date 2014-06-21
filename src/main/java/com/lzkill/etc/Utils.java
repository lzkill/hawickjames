package com.lzkill.etc;

import java.util.Random;

public class Utils {
	
	public static long usedMemory() {
		Runtime rt = Runtime.getRuntime();
		return rt.totalMemory() - rt.freeMemory();
	}
	
	public static void reportPerformanceFor(String msg, long refTime) {
		double time = (System.currentTimeMillis() - refTime) / 1000.0;
		double mem = usedMemory() / (1024.0 * 1024.0);
		mem = Math.round(mem * 100) / 100.0;
		System.out.println(msg + " (" + time + " sec, " + mem + "MB)");
	}
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
