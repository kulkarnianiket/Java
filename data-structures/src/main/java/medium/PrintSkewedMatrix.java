package medium;

/**
 * <p>
 * Print matrix diagonally
 * </p>
 * <p>
 * Approach : increment column till you reach max value, then keep column
 * constant and increment row
 * </p>
 * 
 * @author Aniket Kulkarni
 *
 */
public class PrintSkewedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int count = 0;
		int m = 3;
		int n = 3;
		int i = 0;
		int j = 0;
		int startI = 0;
		int startJ = 0;
		System.out.println(matrix.length);
		while (count < m * n) {
			startI = i;
			startJ = j;
			while (startI < m && startJ >= 0) {
				System.out.print(matrix[startI][startJ]);
				startI++;
				startJ--;
				count++;
				if (count % n == 0) {
					System.out.println();
				}
			}
			if (j == n - 1) {
				i++;
			} else {
				j++;
				i = 0;
			}
		}
	}

}
