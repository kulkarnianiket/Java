package simple;

/**
 * Counts the number of unique elements in an array
 * 
 * @author Aniket Kulkarni
 *
 */
public class RemoveDup {

	public static void main(String[] args) {
		int[] A = { 1, 1, 5, 8, 8, 8, 10, 16, 16, 23 };

		System.out.println(removeDup(A));
	}

	/*
	 * 1. Count the number of unique elements: Given a sorted int array with
	 * duplicate elements, return the number of unique elements. Preferred
	 * solution: speed complexity O(n), space complexity O(1)
	 */
	public static int removeDup(int[] A) {
		// number of unique elements
		int count = 1;
		boolean flag = true;
		int current = A[0];
		for (int i = 1; i < A.length; i++) {
			if (current != A[i]) {
				count++;
				current = A[i];
			}
		}
		return count;
	}

}
