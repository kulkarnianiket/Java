package medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class RomanToInt {
	public static void main(String[] args) {
		ArrayList<Integer> integerResults = new ArrayList<Integer>();
		ArrayList<String> romans = new ArrayList<String>(Arrays.asList("I",
				"II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
				"MMMCMXCI", "MMMCMXCII", "MMMCMXCIII", "MMMCMXCIV", "MMMCMXCV",
				"MMMCMXCVI", "MMMCMXCVII", "MMMCMXCVIII", "MMMCMXCIX"));
		for (int i = 0; i < romans.size(); i++) {
			integerResults.add(romanToInt(romans.get(i)));
		}
		System.out.println(integerResults);

	}

	/**
	 * Convert a Roman numeral into an integer. Guarantee input is within the
	 * range of 1 to 3999.
	 * <p>
	 * Example: ”I”->1,"II"->2 ”III”->3, “IV”->4, “VI”->6, VII->7 “VIII”->8,
	 * “IX”->9, “XI”->11, “XXIX”->29, ”MMMCMXCIX”-> 3999 int[] radix = {1000,
	 * 500, 100, 50, 10, 5, 1}; char[] symbol = {'M', 'D', 'C', 'L', 'X',
	 * 'V','I'};
	 * </p>
	 * 
	 * @param str
	 *            roman numeral to be converted
	 * @return integer equivalent of {@code str}
	 */
	public static int romanToInt(String str) {

		int[] radix = { 1000, 500, 100, 50, 10, 5, 1 };
		char[] symbol = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		// e.g VII -> 5 + 1 + 1
		// e.g IX - > 10 - 1
		// XXIX -> 10 + 10 - 1 + 10

		// add current char only when the following char is less than
		// otherwise subtract current character from sum

		// XXIX ---- X

		String symbols = "";
		for (int i = 0; i < symbol.length; i++) {
			symbols += symbol[i];
		}

		symbols += '\0';

		char[] chars = str.toCharArray();
		int sum = 0;
		char nextChar;
		int currentIndex = 0;
		int nextCharIndex = 0;
		for (int i = 0; i < chars.length; i++) {
			char current = chars[i];
			currentIndex = symbols.indexOf(current);

			if (chars.length == 1) {
				return radix[currentIndex];

			} else {

				if (i == chars.length - 1) {

					sum += radix[currentIndex];
				} else {
					nextChar = chars[i + 1];
					nextCharIndex = symbols.indexOf(nextChar);

					if (currentIndex > nextCharIndex) {
						sum -= radix[currentIndex];

					} else {
						sum += radix[currentIndex];
					}
				}
			}
		}
		return sum;

	}
}
