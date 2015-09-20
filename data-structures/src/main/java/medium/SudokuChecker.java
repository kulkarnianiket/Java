package medium;

import java.util.Arrays;

/**
 * Checks whether the the board contains a sudoku solution
 * 
 * @author Aniket Kulkarni
 *
 */
public class SudokuChecker {

	public static void main(String[] args) {

		int[][] matrix = {

		{ 5, 3, 4, 6, 7, 8, 1, 9, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		System.out
				.println(checkSudokuRowCol(matrix) && checkSudokuGrid(matrix));
	}

	/**
	 * Sorts an array and validates whether the array is in increasing order in
	 * increments of 1
	 * 
	 * @param array
	 *            the array to be validated
	 * @return true if the array is in increasing order in increments of 1,
	 *         false othewise
	 */
	private static boolean validate(int[] array) {

		Arrays.sort(array);
		int k = 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != k++) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks whether row and columns follow sudoku rules
	 * 
	 * @param matrix
	 *            sudoku matrix
	 * @return true, if the rows and columns follow the sudoku rules, otherwise
	 *         false
	 */
	private static boolean checkSudokuRowCol(int[][] matrix) {
		int row[] = new int[9];
		int col[] = new int[9];
		for (int i = 0; i < 9; i++) {
			row = matrix[i].clone();
			for (int j = 0; j < 9; j++) {
				col[j] = matrix[i][j];
			}

			if (!validate(row) && !validate(col)) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Checks whether grids follow sudoku rules
	 * 
	 * @param matrix
	 *            sudoku matrix
	 * @return true, if the grids follow the sudoku rules, otherwise false
	 */

	private static boolean checkSudokuGrid(int matrix[][]) {
		int startIndex = 0;
		int endIndex = 2;
		int grid[] = new int[9];
		int count = 0;
		while (startIndex <= 8 && endIndex <= 8) {
			for (int i = startIndex; i <= startIndex + 2; i++) {
				for (int j = endIndex - 2; j <= endIndex; j++) {
					grid[count++] = matrix[i][j];
				}
			}

			count = 0;
			if (!validate(grid)) {
				return false;
			}

			if (endIndex < 8) {
				endIndex += 3;
			} else {
				startIndex += 3;
				endIndex = 2;
			}
		}

		return true;
	}

}
