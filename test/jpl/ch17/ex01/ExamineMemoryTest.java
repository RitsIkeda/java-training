package jpl.ch17.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExamineMemoryTest {

	@Test
	public void test1() {

		ExamineMemory em = new ExamineMemory();
		em.runGC();

		long before = em.getFreeMemory();
		em.fillMemory(1024, 100);
		long afterFillMem = em.getFreeMemory();
		System.out.println("before:" + before + " afterFillMem:" + afterFillMem);

		assertTrue(before > afterFillMem);
	}

	@Test
	public void test2() {

		ExamineMemory em = new ExamineMemory();
		em.runGC();

		long before = em.getFreeMemory();
		em.fillMemory(1024, 1000);
		long afterFillMem = em.getFreeMemory();
		em.runGC();
		long afterGC = em.getFreeMemory();
		System.out.println("before:" + before + " afterFillMem:" + afterFillMem + " afterGC:" + afterGC);

		assertTrue(before > afterFillMem);
		assertTrue(afterGC > afterFillMem);
	}

}
