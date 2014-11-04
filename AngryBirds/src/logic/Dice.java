package logic;

import java.util.Random;

public class Dice {
	public static int throwDice(int maxNumber) {
		Random gen = new Random();
		return gen.nextInt(maxNumber) + 1;
	}
}
