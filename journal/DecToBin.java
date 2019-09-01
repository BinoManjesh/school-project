package journal;

import java.util.Scanner;

public class DecToBin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number in decimal: ");
		float dec = sc.nextFloat();

		DecToBin obj = new DecToBin();
		System.out.println(obj.getBin(dec));
	}

	private float getBin(float dec) {
		int iDec = (int) dec;
		float fDec = dec - iDec;
		int i = 1;
		float ans = 0;
		while (iDec > 0 || fDec > 0) {
			ans += i * (iDec % 2);
			iDec /= 2;
			i *= 10;

			fDec *= 2;
			ans += ((int) fDec) / (float) i;
			fDec = fDec - (int) fDec;
		}
		return ans;
	}
}
