package com.saansol.algorithms.dynamicprogramming;

/**
 * <pre>
 * This program implements Kadane's Algorithm to find Maximum Sub-Array 
 * Complexity: O(n)
 * 
 * </pre>
 */
public class MaximumSubArrayKadanesAlgorithm {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static int[] maximumSubArray(int[] input) {
		// Check for invalid input
		if (input == null || input.length == 0) {
			throw new IllegalArgumentException("invalid input array");
		}
		// If input lenght is 1 then we simply return the same array
		if (input.length == 1) {
			return input;
		}

		// Initialise the maxSum to the first element in the array.
		// Like we assume first element is the maximum sub array.
		int maxSum = input[0];
		// Set the lower bound of the maximum sub array to 0.
		int maxLowerBound = 0;
		// Set the upper bound of the maximum sub array to 0.
		int maxUpperBound = 0;

		// It holds the intermediate lower bound of the new sub array
		int intermediateLowerBound = 0;

		// It holds the intermediate sum of the sub array
		int intermdediateSum = input[0];

		// Loop starts from index 1 in the array
		for (int i = 1; i < input.length; i++) {
			// add the current element to intermediate sum.
			intermdediateSum += input[i];

			// if current element is creator than the intermediate sum then we
			// need to start with new sub array as per Kadane's algorithm.
			if (input[i] > intermdediateSum) {
				// Set the intermediate bound to new index
				intermediateLowerBound = i;
				// Set the intermediateSum to value of current element.
				intermdediateSum = input[i];
			}
			// Update maxSum if intermdediateSum is greater than current maxSum
			if (intermdediateSum > maxSum) {
				// update the maxLowerBound to current intermediateLowerBound
				maxLowerBound = intermediateLowerBound;
				// update the maxUpperBound to current index
				maxUpperBound = i;
				// update the maxSum to intermediateSum
				maxSum = intermdediateSum;
			}
		}
		// create a new array. Both maxUpperBound & maxLowerBound are inclusive
		// so size of the array is maxUpperBound - maxLowerBound + 1
		int[] output = new int[maxUpperBound - maxLowerBound + 1];
		System.arraycopy(input, maxLowerBound, output, 0, output.length);
		return output;

	}
}
