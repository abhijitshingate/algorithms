package com.saansol.algorithms.dynamicprogramming;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestMaximumSubArrayKadanesAlgorithm extends TestCase {

	public void testMaximumSubArray() {
		int[] input = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] output = MaximumSubArrayKadanesAlgorithm.maximumSubArray(input);
		int[] expectedOutput = new int[] { 4, -1, -2, 1, 5 };
		assertEquals("Input & Ouput array lenths do not match",
				expectedOutput.length, output.length);
		assertTrue("unexpected maximum subarray",
				Arrays.equals(expectedOutput, output));

		// Input contains all negative elements
		input = new int[] { -2, -3, -4, -1, -2, -1, -5, -3 };
		output = MaximumSubArrayKadanesAlgorithm.maximumSubArray(input);
		expectedOutput = new int[] { -1 };
		assertEquals("Input & Ouput array lenths do not match",
				expectedOutput.length, output.length);
		assertTrue("unexpected maximum subarray",
				Arrays.equals(expectedOutput, output));

	}
}
