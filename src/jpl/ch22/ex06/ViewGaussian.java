package jpl.ch22.ex06;

import java.util.Random;

public class ViewGaussian {

	static void viewGaussian(int sampleNum) {
		Random random = new Random();
		double width = 0.1;
		double min = -3.5;
		double max = 3.5;

		int counts[] = new int[ (int) ((max - min) / width) + 2];

		for(int i = 0; i < sampleNum; i++ ) {
			double result = random.nextGaussian();
			int index = (int) ((result - min) / width);
			index = Math.min(index, counts.length - 1);
			index = Math.max(index, 0);

			counts[index]++;
		}
		for(int count : counts ) {
			for(int i = 0; i < count; i++) {
				System.out.print("*");

			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		//viewGaussian(50);
		viewGaussian(1000);

	}

}
