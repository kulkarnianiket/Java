package medium;

/* Sample code to read in test cases:*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LowestCommonAncestor {
	static int[] tree = { 30, 8, 52, 3, 20, -1, -1, -1, -1, 10, 29 };
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int x, y;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			String[] numbers = line.split("\\s+");
			x = Integer.parseInt(numbers[0]);
			y = Integer.parseInt(numbers[1]);
			if (x < y) {
				System.out.println(lowestCommonAncestor(x, y));
			} else {
				System.out.println(lowestCommonAncestor(y, x));
			}
		}
	}

	public static int lowestCommonAncestor(int x, int y) {
		int root = 0;
		boolean isXSmaller = true;
		boolean isYSmaller = true;
		while (root < tree.length) {
			if (x == tree[root] || y == tree[root]) {
				return tree[root];
			}
			isXSmaller = x < tree[root] ? true : false;
			isYSmaller = y < tree[root] ? true : false;
			if (isXSmaller && !isYSmaller) {
				return tree[root];
			} else if (isXSmaller && isYSmaller) {
				root = leftChild(root);
			} else if (!isXSmaller && !isYSmaller) {
				root = rightChild(root);
			}
		}
		return tree[root];

	}

	public static int leftChild(int x) {
		return 2 * x + 1;
	}

	public static int rightChild(int x) {
		return 2 * x + 2;
	}
}

