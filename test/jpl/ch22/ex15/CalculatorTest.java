package jpl.ch22.ex15;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CalculatorTest {

	private final double RANGE = 0.0001;
	@Test
	public void test1() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.calculate("1 2 +"),RANGE);
			assertEquals(-1, calc.calculate("1 2 -"),RANGE);
			assertEquals(6, calc.calculate("2 3 *"),RANGE);
			assertEquals(2.0 /3.0, calc.calculate("2 3 /"),RANGE);
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void test2() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3.1 * 4.2 - 1, calc.calculate("3.1 4.2 * 1 -"),RANGE);
			assertEquals((1.2 * 2.3) / (3.4 - 3.5), calc.calculate("1.2  2.3 *  3.4  3.5 - /"),RANGE);

		} catch (IOException e) {
			fail();
		}
	}

}
