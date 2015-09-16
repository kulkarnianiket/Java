package simple;

import java.util.Scanner;

public class TimeConverter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String timeString = sc.nextLine();

		String[] time = timeString.split(":");
		int hour = 0;

		// AM or PM
		String timeOfDay = time[2].substring(time[2].length() - 2);
		String seconds = time[2].substring(0, 2);
		String minutes = time[1];
		hour = Integer.parseInt(time[0]);

		if (timeOfDay.equalsIgnoreCase("PM")) {
			if (hour < 12) {
				hour += 12;
			}
		}

		String hourString = String.valueOf(hour);
		if (hourString.length() == 1) {
			hourString = "0" + hour;
		}
		System.out.println(hourString + ":" + minutes + ":" + seconds);

	}
}
