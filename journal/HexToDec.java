package journal;

import java.util.Scanner;

/**
 * 2. Write a program to accept a hexadecimal number and convert it to decimal
 */
class HexToDec {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number in hexadecimal: ");
        String n = sc.next();

        HexToDec obj = new HexToDec();
        System.out.println(n + " in decimal is: " + obj.getDec(n));
    }

    double getDec(String n) {
        double dec = 0.0;
        int j = n.indexOf(".");
        int length = n.length();
        if (j == -1) {
            j = length - 1;
        } else {
            j--;
        }
        for (int i = 0; i < length; i++) {
            char c = n.charAt(i);
            if (Character.isDigit(c)) {
                dec += Integer.parseInt(c + "") * Math.pow(16, j);
            } else if (c == '.') {
                continue;
            } else {
                dec += ((int) c - 55) * Math.pow(16, j);
            }
            j--;
        }
        return dec;
    }
}
