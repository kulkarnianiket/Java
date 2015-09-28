package medium;

/**
 * <p>
 * Amicable Pair/Number (A, B) A> 0, B> 0, A != B 
 * sum(divisors of A, excluding A) = B 
 * sum(divisors of B, excluding B) = A 
 * <br>
 * (220, 284) 
 * 220 --> 1 + 2 + 4 + 5 +... + 110 = 284 
 * 284 --> 1+ 2+ 4+ .... 142 = 220
 * </p>
 * find all amicable pairs which are in [1, N]
 * 
 * @author Aniket
 *
 */

public class AmicablePairs {
	public static void main(String args[]) {
		int n = 6000;

		// find the divisor of a given number and sum those up and store them
		// array of 300 elements .. store the sum of divisors in respective
		// index.
		// check array for value and check the array[value] , if they match then
		// print out the pairs.

		// divisor function = O(n) .because it divides the number repeatedly to
		// find the divisors
		// inserting into array = O(n*n) as it goes through the entire range
		// between 1..N and calls divisorSum function each time

		int divisorSumArray[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			divisorSumArray[i] = divisorSum(i);
		}

		int current = 0;
		int match = 0;
		for (int i = 1; i <= n; i++) {
			current = divisorSumArray[i];
			if (current <= n) {
				match = divisorSumArray[current];
			}

			if (match == i) {
				if (current < match) {
					System.out.println(current + " , " + match);
				}
			}
		}

	}

	/**
	 * Find the sum of divisors of given number excluding itself
	 * 
	 * @param num
	 *            number whose divisor sum needs to be calculated
	 * @return sum of divisors of {@code num}
	 */

	private static int divisorSum(int num) {
		int sum = 0;

		if (num == 1) {
			return 0;
		}

		for (int i = 1; i < num / 2 + 1; i++) {
			// num is divisible by i
			if (num % i == 0) {

				sum += i;

			}

		}
		return sum;

	}
}
