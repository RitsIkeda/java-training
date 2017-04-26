package jpl.ch22.ex01;

public class DecimalFormatter {

	private static final int MAX_WIDTH = 80;


	public static void main(String[] args) {

		double[] values = {
				1,10,100,1000,10000,100000,100000,
				0.1,0.01,0.01,0.001,0.0001,0.00001,
				1.23456789,12.3456789,123.456789,
				1234.56789,12345.6789,123456.789,
				1234567.89,12345678.9,123456789
				};
		decimalFormatter(values,1);
		System.out.println();
		decimalFormatter(values,3);
		System.out.println();
		decimalFormatter(values,5);
		System.out.println();
		decimalFormatter(values,7);
		System.out.println();
		decimalFormatter(values,9);
		System.out.println();
		decimalFormatter(values,11);
		System.out.println();
		decimalFormatter(values,13);
		System.out.println();
	}





	public static void decimalFormatter(double[] values, int rows) {
		int width = ((MAX_WIDTH  - (rows - 1)) / rows);
		width = Math.min(15, width);
		int i = 0;
		while(i < values.length) {
			for(int j = 0; j < rows && i < values.length; i++ ,j++) {
				System.out.print(format(values[i], width));
				if(j < rows - 1) {System.out.print(' ');}
			}
			System.out.println();
		}
	}


	private static String format(double value, int width) {
		switch (width) {
		case 5:
			return String.format("%1$5.1e", value);

		case 6:
			return String.format("%1$6.2e", value);

		case 7:
			return String.format("%1$7.3e", value);

		case 8:
			return String.format("%1$8.4e", value);

		case 9:
			return String.format("%1$9.5eg", value);

		case 10:
			return String.format("%1$10.6e", value);

		case 11:
			return String.format("%1$11.7e", value);

		case 12:
			return String.format("%1$12.8e", value);

		case 13:
			return String.format("%1$13.9", value);

		case 14:
			return String.format("%1$14.10g", value);

		case 15:
			return String.format("%1$15.10g", value);

		default:
			throw new RuntimeException("unsupported width.");
		}
	}
}
