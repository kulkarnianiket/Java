package hard;

/* Sample code to read in test cases: */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LongestCommonSubsequence {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			String words[] = line.split(";");

			System.out.println(lcs(words[0].toCharArray(),
					words[1].toCharArray()));

		}
	}

	private static String lcs(char[] a, char[] b) {
		int s[][] = new int[a.length + 1][b.length + 1];

		for (int i = 0; i <= a.length; i++) {
			for (int j = 0; j <= b.length; j++) {
				if (i == 0 || j == 0) {
					s[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					s[i][j] = 1 + s[i - 1][j - 1];
				} else {
				s[i][j] = Math.max(s[i - 1][j], s[i][j - 1]);
				}

			}
		}

		int i = a.length, j = b.length;
		String lcs = new String();
		while (i > 0 && j > 0) {
			if (a[i - 1] == b[j - 1]) {
				lcs = a[i - 1] + lcs;
				i--;
				j--;
			} else {
				if (s[i - 1][j] > s[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return lcs;

	}
}


