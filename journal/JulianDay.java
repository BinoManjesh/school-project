package journal;

import java.util.Scanner;

class JulianDay {
	
	private static final int[] DAYS = 
		new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) {
		JulianDay obj = new JulianDay();
		Scanner sc = new Scanner(System.in);
		boolean shouldRun = true;
		do {
			System.out.println("Enter:-\n" +
				"1 to convert julian day to normal day\n" +
				"2 to convert normal day to julian day\n" +
				"3 to exit");
			int ch = sc.nextInt();
			if (ch == 1) {
				System.out.print("Enter the julian day: ");
				int julianDay = sc.nextInt();
				System.out.print("Enter the year: ");
				int year = sc.nextInt();
				System.out.println(obj.getNormalDay(julianDay, year));
			} else if (ch == 2) {
				System.out.print("Enter the day: ");
				int day = sc.nextInt();
				System.out.print("Enter the month: ");
				int month = sc.nextInt();
				System.out.print("Enter the year: ");
				int year = sc.nextInt();
				System.out.println(obj.getJulianDay(day, month, year));
			} else if (ch == 3) {
				shouldRun = false;
			}
			System.out.println();
		} while (shouldRun);
	}
	
	private String getNormalDay(int julianDay, int year) {
		int month = 0;
		boolean isLeapYear = year % 4 == 0;
		while (julianDay - DAYS[month] > 0) {
			if (isLeapYear && month == 1) {
				julianDay--;
			}
			julianDay -= DAYS[month];
			month++;
		}
		return format(julianDay) +"/" + format(month + 1) + "/" + year;
	}
	
	private String format(int n) {
		if (n < 10) {
			return "0" + n;
		} else {
			return n + "";
		}
	}
	
	private int getJulianDay(int day, int month, int year) {
		int julianDay = day;
		month -= 2;
		while (month >= 0) {
			julianDay += DAYS[month--];
		}
		if (year % 4 == 0) {
			julianDay++;
		}
		return  julianDay;
	}
}
