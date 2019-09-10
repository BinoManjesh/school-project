package journal;

import java.util.Scanner;

class PasswordGenerator {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first name: ");
		String firstName = sc.next();
		System.out.print("Enter your middle name: ");
		String middleName = sc.next();
		System.out.print("Enter your last name: ");
		String lastName = sc.next();
		System.out.print("Enter your age: ");
		int age = sc.nextInt();
		
		PasswordGenerator g = new PasswordGenerator();
		System.out.println(g.genPassword(firstName, middleName, lastName, age));
	}
	
	private String genPassword(String firstName, String middleName,
		String lastName, int age) {
		return getFirstLastLetter(lastName) + (age / 10) +
		getFirstLastLetter(firstName) + (age % 10) + getFirstLastLetter(middleName);
	}
	
	private String getFirstLastLetter(String s) {
		return s.charAt(0) + "" + s.charAt(s.length() - 1);
	}
}
