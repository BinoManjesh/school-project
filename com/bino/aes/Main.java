package com.bino.aes;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cipher cipher = new Cipher();
        Decipher decipher = new Decipher();
        int ch;
        do {
            System.out.println("Enter a string:-");
            String text = sc.nextLine();
            System.out.println("Enter the key:-");
            String key = sc.nextLine();
            System.out.println("Enter:-\n0 to encrypt the text\n1 to decrypt\n2 to exit\t");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    System.out.println(cipher.getCipherText(text, key));
                    break;
                case 1:
                    System.out.println(decipher.getPlainText(text, key));
                    break;
                default:
                    System.out.println("Please enter 0, 1 or 2 only");
            }
        } while (ch != 2);
    }
}
