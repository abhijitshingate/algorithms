package com.saansol.algorithms.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGCD {

	@Test
	public void testFindGCD() {
		// Test for positive numbers
		assertEquals("unexpected GCD", 6, GCD.findGCD(12, 18));
		// Test for first negative number
		assertEquals("unexpected GCD", 6, GCD.findGCD(-12, 18));
		// Test for second negative number
		assertEquals("unexpected GCD", 6, GCD.findGCD(12, -18));
		// Test for negative numbers
		assertEquals("unexpected GCD", 6, GCD.findGCD(-12, -18));
		// Test for first zero number
		assertEquals("unexpected GCD", 18, GCD.findGCD(0, 18));
		// Test for second zero number
		assertEquals("unexpected GCD", 12, GCD.findGCD(12, 0));
		// Test for negative numbers
		assertEquals("unexpected GCD", 0, GCD.findGCD(0, 0));

	}
}
