package medium;

/* Sample code to read in test cases:*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CycleString {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			String lineArray[] = line.split("\\s+");
			cycleString(lineArray);
		}
	}

	public static void cycleString(String[] line) {
		int next = 0;
		String currentChar = new String();
		String nextChar = new String();
		boolean flag = false;
		int currentIndex = 0;
		for (int i = 0; i < line.length; i++) {
			currentChar = line[i];
			currentIndex = i;
			for (int j = i + 1; j < line.length; j++) {
				nextChar = line[j];
				if (nextChar.equals(currentChar)) {
					next = j;
					while (currentIndex < j) {
						if (line[currentIndex].equals(line[next])) {
							currentIndex++;
							next++;
							flag = true;
						} else {
							flag = false;
							break;
						}
					}
					if (flag == true) {
						for (int k = i; k < j; k++) {
							if (k == j - 1) {
								System.out.print(line[k]);
							} else {
								System.out.print(line[k] + " ");
							}
						}
						break;
					}
				}
			}
			if (flag == true) {
				break;
			}
		}
		System.out.println();
	}
}

