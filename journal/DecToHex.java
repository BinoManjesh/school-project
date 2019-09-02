package journal;

import java.util.Scanner;

class DecToHex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number in decimal: ");
        float dec = sc.nextFloat();

        DecToHex obj = new DecToHex();
        System.out.println(dec + " in hexadecimal is: " + obj.getHex(dec));
    }

    private String getHex(float dec) {
        int iDec = (int) dec;
        float fDec = dec - iDec;
        StringBuffer hex;
        if (fDec > 0) {
            hex = new StringBuffer(".");
            while (fDec > 0) {
                fDec *= 16;
                hex.append(getChar((int) fDec));
                fDec = fDec - (int) fDec;
            }
        } else {
            hex = new StringBuffer();
        }
        while (iDec > 0) {
            hex.insert(0, getChar(iDec % 16));
            iDec /= 16;
        }

        return hex.toString();
    }

    private char getChar(int digit) {
        if (digit > 9) {
            return (char) (65 - 10 + digit);
        } else {
            return (digit + "").charAt(0);
        }
    }
}
