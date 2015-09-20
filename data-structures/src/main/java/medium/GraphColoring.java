package medium;

/**
 * Tests whether a graph can be colored with m colors so that no two adjacent
 * vertices have the same color.
 * 
 * Negative test : m = 2
 * 
 * @author Aniket
 *
 */
public class GraphColoring {

	public static void main(String[] args) {

		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 },
				{ 1, 0, 1, 0 }, };

		int m = 3; // Number of colors
		graphColoring(graph, m);
	}

	private static boolean graphColoring(int[][] graph, int m) {
		int color[] = new int[4];

		for (int i = 0; i < 4; i++) {
			color[i] = 0;
		}

		if (graphColoringUtil(graph, m, color, 0) == false) {
			System.out.println("No solution exists");
			return false;
		}

		printSolution(color);
		return true;

	}

	private static boolean safeColor(int v, int[][] graph, int color[], int c) {

		for (int i = 0; i < 4; i++) {
			if (graph[v][i] == 1 && c == color[i]) {
				return false;
			}
		}

		return true;

	}

	private static boolean graphColoringUtil(int graph[][], int m, int color[],
			int v) {

		if (v == 4) {
			return true;
		}

		for (int i = 1; i <= m; i++) {
			if (safeColor(v, graph, color, i)) {

				color[v] = i;

				if (graphColoringUtil(graph, m, color, v + 1) == true) {
					return true;
				}

				color[v] = 0;
			}
		}

		return false;

	}

	private static void printSolution(int color[]) {
		for (int i = 0; i < 4; i++) {
			System.out.print(color[i] + " ");
		}
	}

}
