package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * INPUT SAMPLE:
 * 
 * Your program should accept a path to a file as its first argument. The file
 * contains multiple lines. The first line indicates the number of lines you
 * should output, the other lines are of different length and are presented
 * randomly. You may assume that the input file is formatted correctly and the
 * number in the first line is a valid positive integer. For example: Hello
 * World CodeEval Quick Fox A San Francisco OUTPUT SAMPLE:
 * 
 * Print out the longest lines limited by specified number and sorted by their
 * length in descending order.
 * 
 * For example: San Francisco Hello World
 * 
 * @author Aniket Kulkarni
 *
 */
public class MaxLines {
	/* Sample code to read in test cases: */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		boolean flag = false;
		int count = 0;
		TreeSet<String> lineSet = new TreeSet<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.length() > s1.length() ? 1
						: s2.length() == s1.length() ? 0 : -1;
					}
				});
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			if (!flag) {
				count = Integer.parseInt(line);
				flag = true;
			} else {
				lineSet.add(line);
			}

		}

		Iterator<String> iter = lineSet.iterator();
		while (count != 0 && iter.hasNext()) {
			System.out.println(iter.next());
			count--;
		}
	}
}

