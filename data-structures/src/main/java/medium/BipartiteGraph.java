package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Test whether graph is bipartite or no. This is an extension of m coloring
 * problem where m = 2.
 * 
 * <p>
 * Negative test : int graph[][] = {
 * </p>
 * <p>
 * { 0, 1, 1, 1 },
 * </p>
 * <p>
 * { 1, 0, 1, 0 },
 * </p>
 * <p>
 * { 1, 1, 0, 1 },
 * </p>
 * <p>
 * { 1, 0, 1, 0 }
 * </p>
 * <p>
 * ;
 * </p>
 * 
 * @author Aniket
 *
 */
public class BipartiteGraph {

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 },
				{ 1, 0, 1, 0 } };

		System.out.println(isBipartite(graph) ? "yes" : "no");
	}

	private static boolean isBipartite(int[][] graph) {
		int color[] = new int[graph.length];

		for (int i = 0; i < color.length; i++) {
			color[i] = -1;
		}

		color[0] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		while (q.size() != 0) {
			int current = q.remove();

			for (int i = 0; i < graph.length; i++) {
				if (graph[current][i] == 1 && color[i] == -1) {
					color[i] = 1 - color[current];
					q.add(i);
				} else if (graph[current][i] == 1 && color[i] == color[current]) {
					return false;
				}
			}
		}

		return true;
	}

}
