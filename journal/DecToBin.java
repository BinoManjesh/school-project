package journal;

import java.util.Scanner;

public class DecToBin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number in decimal: ");
		float dec = sc.nextFloat();

		DecToBin obj = new DecToBin();
        System.out.println(dec + " in binary is: " + obj.getBin(dec));
	}

	private float getBin(float dec) {
		int iDec = (int) dec;
		float fDec = dec - iDec;
        StringBuffer bin = new StringBuffer(".");
        while (iDec > 0) {
            bin.insert(0, iDec % 2);
			iDec /= 2;
        }
        while (fDec > 0) {
			fDec *= 2;
            bin.append((int) fDec);
			fDec = fDec - (int) fDec;
		}
        return Float.valueOf(bin.toString());
	}
}
