package com.saansol.projecteuler;

/**
 * Project Euler: Problem 1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * It implements the logic to calculate the sum of all the terms of the
 * arithmetic expression with given first term, commonDifference and given upper
 * limit on the term.
 * 
 */
public class Problem1_ArithmaticProgression {

	/**
	 * First term of the arithmetic progression.
	 */
	private int firstTerm;

	/**
	 * Common difference in the arithmetic progression.
	 */
	private int commonDifference;

	/**
	 * Create arithmetic progression with given first term and common
	 * difference.
	 * 
	 * @param firstTerm
	 * @param commonDifference
	 */
	public Problem1_ArithmaticProgression(int firstTerm, int commonDifference) {
		super();
		this.firstTerm = firstTerm;
		this.commonDifference = commonDifference;
	}

	/**
	 * Calculates the sum of all the terms in this arithmetic expression below
	 * given upper limit. It uses arithmetic sequence sum calculation format.
	 * 
	 * <pre>
	 *  Arithmetic sequence sum calculation.
	 *  Let
	 *  	a = first term
	 *  	d = common difference 
	 *  	s = Sum of n terms
	 * Then,
	 * 	s = (n * (2a + (n -1)d) ) / 2
	 * 
	 * <b>Note:</b> 
	 * Make sure you the division by 2 to be done only after all other calculations are done in above formula.
	 * Because if you first devide n by 2 and then calculate (2a + (n -1)d) then the final answer may be wrong.
	 * Because if n is odd then division by 2 will simply ignore the fraction.  
	 * If you divide by 2 in the end then it is guaranteed that for any value of n, 
	 * either n is even or the result of (2a + (n -1)d)  expression is even. so there wont be any fraction generated.
	 * And not information is lost.
	 * </pre>
	 * 
	 * @return sum
	 */
	public int sum(int upperLimit) {
		// Get the maximum term in the sequence below upperLimit
		int maxTerm = getMaxTermInTheSequence(upperLimit);
		// Find the index of the maximum term in the sequence.
		// It is same as the number of terms in the sequence.
		int indexOfMaxTerm = getIndexOfTermInTheSequence(maxTerm);
		// Use arithmetic expression to calculate the sum.
		return (indexOfMaxTerm * (2 * firstTerm + (indexOfMaxTerm - 1)
				* commonDifference)) / 2;
	}

	/**
	 * Returns the index of a given term in the sequence.
	 * 
	 * <pre>
	 * For example, 
	 * Lets say 
	 * First term = 3; 
	 * Common Difference = 3;
	 * upperLimit = 20; 
	 * 
	 * Arithmetic sequence below upperLimit 20 = 3, 6, 9, 12, 15, 18
	 * 
	 * If 18 is passed to this function then it will return 6. 
	 * If you look at above sequence, then 18 is 6th term in the sequence.
	 * </pre>
	 * 
	 * 
	 * @param term
	 * @return index of the term in the sequence
	 */
	private int getIndexOfTermInTheSequence(int term) {
		// Formula to calculate nth term in arithmatic sequence is
		// nth term = a + ( n - 1 ) d
		// where,
		// a = first term
		// d = common difference.
		// So if we have n th term then formula to find n is
		// n = ( ( nth term - a ) / d) + 1
		return ((term - firstTerm) / commonDifference) + 1;
	}

	/**
	 * It returns the maximum term present in the arithmetic expression with
	 * given common difference and below the upperLimit.
	 * 
	 * upperLimit is inclusive in the sequence.
	 * 
	 * <pre>
	 * Lets say 
	 * First term = 3; 
	 * Common Difference = 3;
	 * upperLimit = 20; 
	 * 
	 * Arithmetic sequence below upperLimit 20 = 3, 6, 9, 12, 15, 18
	 *  
	 * The maximum term in the sequence is 18 below upperLimit 20
	 * 
	 * </pre>
	 * 
	 * @param upperLimit
	 * @param commonDifference
	 * @return maximum term in the arithmetic sequence
	 */
	private int getMaxTermInTheSequence(int upperLimit) {
		// To find max term, divide the upperLimit with common difference and
		// multiple it again with commonDifference.
		// For example, (20 / 3) * 3 = (6) * 3 = 18;
		return (upperLimit / commonDifference) * commonDifference;
	}

	public static void test() {
		int sum3 = 0;
		int i = 3;
		for (i = 3; i < 1000; i += 3) {
			if (i % 5 == 0)
				continue;
			sum3 += i;
		}

		int sum5 = 0;
		i = 5;
		for (i = 5; i < 1000; i += 5) {
			sum5 += i;
		}

		System.out.println(sum3 + sum5);

	}

	public static void main(String[] args) {

		int sumOfMultuiplesOf3Below1000 = new Problem1_ArithmaticProgression(3, 3)
				.sum(999);

		int sumOfMultuiplesOf5Below1000 = new Problem1_ArithmaticProgression(5, 5)
				.sum(999);

		int sumOfMultuiplesOf15Below1000 = new Problem1_ArithmaticProgression(15, 15)
				.sum(999);

		System.out.println(sumOfMultuiplesOf3Below1000
				+ sumOfMultuiplesOf5Below1000 - sumOfMultuiplesOf15Below1000);

	}
}
