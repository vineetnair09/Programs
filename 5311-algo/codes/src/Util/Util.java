package Util;

import java.util.Random;

public class Util {
	public static int rand(int min, int max) {
		Random rand = new Random();
		return  rand.nextInt((max - min) + 1) + min;
	}	
}
