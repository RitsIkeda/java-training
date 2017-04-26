package jpl.ch22.ex05;

import java.util.Random;


/*  練習問題 22.5
 * ほぼ、1/6と同じ確率に収束することを確認した。
 * また、乱数発生メソッドは基本的にどれを用いてもよい。
 * ただし、nextGaussinanを用いると値が中央に偏う事と、
 * 複数のRandomオブジェクトを並列に扱う時は、シード値を変えることに注意が必要。
 * */

public class DiceSum {

	private Random random;
	private int[] countsForEachResult = new int[11];
	public static final int MINIMUM = 2;

	private int sumCount = 0;

	public DiceSum() {
		random = new Random();
	}
	public DiceSum(int seed) {
		random = new Random(seed);
	}


	void shakeTwoDice(int count) {
		for(int i = 0; i < count; i++) {
			shakeTwoDices();
		}
	}

	public int shakeTwoDices() {
		int result = shakeDice() +  shakeDice();
		countsForEachResult[result - MINIMUM]++;
		sumCount++;
		return result;

	}

	public int shakeDice() {
		return random.nextInt(6) + 1;
	}

	public double getRatio(int index) {
		return (double) countsForEachResult[index] / sumCount;
	}


	public static void main(String[] args) {
		DiceSum diceSum = new DiceSum();
		diceSum.shakeTwoDice(100000);
		for(int i = 0; i < 11; i++) {
			System.out.println(  i + MINIMUM + ": " + diceSum.getRatio(i) * 100 + " %");
		}

		DiceSum diceSumSeed = new DiceSum(10);
		diceSumSeed.shakeTwoDice(100000);
		for(int i = 0; i < 11; i++) {
			System.out.println(  i + MINIMUM + ": " + diceSumSeed.getRatio(i) * 100 + " %");
		}

	}



}
