package hard;

/* Sample code to read in test cases:*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Substring {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"/Users/Aniket/Documents/programming/workspace/Java/data-structures/src/main/java/hard/input.txt");
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			// Process line of input Here

			String[] inputs = line.split(",");

			System.out.println(subString(inputs[0].toCharArray(),
					inputs[1].toCharArray()));

		}
	}

	/*
	 * abcde,abc abcde,cde abcde,abd abcde,*bcde
	 */
	private static boolean subString(char[] main, char[] sub) {
		int mLength = main.length;
		int subLength = sub.length;

		int matchLength = 0;
		int i = 0;
		int j = 0;
		boolean matchChar = false;
		boolean starFound = false;
		while (j < subLength && i < mLength) {
			// if equal then check for next index
			if (sub[j] == main[i]) {
				i++;
				j++;
				matchLength++;
				matchChar = true;
			} else if (sub[j] == '*') {
				starFound = true;
				if (j == subLength - 1) {
					matchLength++;
					break;
				} else {
					j++;
					matchLength++;
				}
			} else if (sub[j] == '\\' && sub[j + 1] == '*') {
				if (sub[j + 1] == main[i]) {
					i++;
					j += 2;
					matchLength += 2;
					matchChar = true;
				}
			} else {
				if (!starFound) {
					matchChar = false;
					matchLength = 0;
					j = 0;
				}
				i++;
			}
		}

		if (matchLength == subLength) {
			return true;
		}

		return false;
	}
}
