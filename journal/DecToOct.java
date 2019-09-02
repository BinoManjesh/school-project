package journal;

import java.util.Scanner;

class DecToOct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number in decimal: ");
        float dec = sc.nextFloat();

        DecToOct obj = new DecToOct();
        System.out.println(dec + " in octal is: " + obj.getOctal(dec));
    }

    private float getOctal(float dec) {
        int iDec = (int) dec;
        float fDec = dec - iDec;
        StringBuffer oct = new StringBuffer(".");
        while (iDec > 0) {
            oct.insert(0, iDec % 8);
            iDec /= 8;
        }
        while (fDec > 0) {
            fDec *= 8;
            oct.append((int) fDec);
            fDec = fDec - (int) fDec;
        }
        return Float.valueOf(oct.toString());
    }
}
