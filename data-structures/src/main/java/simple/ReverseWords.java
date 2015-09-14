package simple;

//Sample code to read in test cases:
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class ReverseWords {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			String reverseString[] = line.split("\\s+");
			for (int i = reverseString.length - 1; i >= 0; i--) {
				if (i == 0) {
					System.out.print(reverseString[i]);
				} else {
				System.out.print(reverseString[i] + " ");
				}
			}
			System.out.println();
		}
	}
}