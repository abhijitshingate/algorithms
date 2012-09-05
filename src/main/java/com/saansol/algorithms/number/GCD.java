package com.saansol.algorithms.number;

public class GCD {

	/**
	 * Calculates the GCD for given two numbers.
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int findGCD(int num1, int num2) {
		// If first number is negative then we convert it into positive by
		// multiplying it with -1.
		if (num1 < 0) {
			num1 = -1 * num1;
		}

		// If second number is negative then we convert it into positive by
		// multiplying it with -1.
		if (num2 < 0) {
			num2 = -1 * num2;
		}

		// if first number is 0 then we check if second number is non zero. If
		// second number is non zero then it is GCD otherwise both numbers are 0
		// so 0 is GCD.
		if (num1 == 0) {
			if (num2 != 0) {
				return num2;
			} else {
				return num1;
			}

		}

		// if second number is 0 then we check if first number is non zero. If
		// first number is non zero then it is GCD otherwise both numbers are 0
		// so 0 is GCD.
		if (num2 == 0) {
			if (num1 != 0) {
				return num1;
			} else {
				return num2;
			}

		}

		// If one of the numbers if 1 then 1 is the GCD
		if (num1 == 1 || num2 == 1) {
			return 1;
		}

		// Euclid's Algorithm
		// Divide the smaller number from larger number until both of them
		// become equal.
		while (num1 != num2) {
			// if first number is greater than second then subtract the second
			// number from first number and assign the resulted value to first
			// number.
			if (num1 > num2) {
				num1 = num1 - num2;
			} else {
				// Else second number is greater than first then subtract the
				// first
				// number from second number and assign the resulted value to
				// second
				// number.
				num2 = num2 - num1;
			}
		}
		// As both numbers are equal now, we have found the GCD.
		return num1;
	}
}
