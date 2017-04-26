package jpl.ch22.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloatAccumulaterTest {

	private static final double RANGE = 0.00001;

	@Test
	public void test1() {
		assertEquals(10, FloatAccumulater.accumulate("1 2 3 4"),RANGE);
	}

	@Test
	public void test2() {
		assertEquals(0.5, FloatAccumulater.accumulate("-1 2.5 3.5 -4.5"),RANGE);
	}

}
