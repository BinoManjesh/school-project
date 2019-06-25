package journal;

import java.util.Scanner;

/**
 * 1. Write a program to accept a binary number and convert it to decimal
 */
class BinToDec {
    
    double getDec (String n) {
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
            if (c == '.') {
                continue;
            }
            dec += Integer.parseInt(c + "") * Math.pow(2, j);
            j--;
        }
        return dec;
    }
    
    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number in binary: ");
        String n = sc.next();
        
        BinToDec obj = new BinToDec();
        System.out.println(n + " in decimal is: " + obj.getDec(n));
    }
}
