package com.saansol.projecteuler;

public class Problem3_PrimeFactorization {
	
	private static long counter = 0;

	/**
	 * <b>Problem 3</b>
	 * 
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 * 
	 * <b>Solution:</b>
	 * 
	 * It finds the largest prime factor of a number by successively removing
	 * dividing by all the prime numbers starting from 2 until the number
	 * becomes 1.
	 * 
	 * <pre>
	 * For example,
	 * Lets say number = 20;
	 * we start with lowest prime number 2.
	 * number = 20, factor = 2;
	 * 20/2 = 10;
	 * number = 10; factor = 2;
	 * 10/2 = 5;
	 * we can not divide 5 by 2 so we increment the factor to 3
	 * Again we can not divide 5 by 3 so we increment the factor to 4
	 * but 4 is even number so we increment again. So the factor is now 5;
	 * number = 5, factor =5;
	 * 5/5 = 1;
	 * So now the value of number is 1 that means we have found our largest prime factor.
	 * For number 20, the largest prime factor is 5;
	 * 
	 * 
	 * </pre>
	 * 
	 * @param number
	 *            - whose prime factor to be found.
	 * @return -1 if the number is less than 2 otherwise the largest prime
	 *         factor of the number.
	 */
	private static long largestPrimeFactor(long number) {
		// If number is less than 2 then simple return -1
		if (number < 2) {
			return -1;
		}

		// If number is 2 or 3 then simply return the number
		if (number == 2 || number == 3) {
			return number;
		}

		// Start factoring from smallest prime number which is 2
		long factor = 2;
		while (true) {
			counter++;
			// When remove all the factors from the number then number is
			// reduced to only 1. It means we have found our factor;
			if (number == 1) {
				System.out.println(counter);
				return factor;
			}

			// If the number can not be divided by factor then we have to move
			// to the next number.
			if ((number % factor) != 0) {
				// increment the factor
				factor++;
				// Small optimization: if number is even then we increment
				// factor again as we already have removed all 2s from the
				// number.
				if ((factor & 1) == 0) {
					factor++;
				}
			} else {
				// Remove the factor from the number
				number = (number / factor);
			}
		}
		

	}

	public static void main(String[] args) {
		long before = System.nanoTime();
		long largestPrimeFactor = largestPrimeFactor(600851475143L);
		long total = System.nanoTime() - before;
		System.out.println(total);
	}

}
