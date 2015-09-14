package simple;

/* Sample code to read in test cases:*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class SumOfNumbers {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int sum = 0;
		int number = 0;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			number = Integer.parseInt(line);
			while (number > 0) {
				sum += number % 10;
				number = number / 10;
			}
			System.out.println(sum);
			sum = 0;
		}
	}
}

