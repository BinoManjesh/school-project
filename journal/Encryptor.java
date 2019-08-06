package journal;

import java.util.Scanner;

class Encryptor {

    private StringBuffer encrypt(String s, int n) {
        StringBuffer encrypted = new StringBuffer(s);
        for(int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            if(Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                int newC = ((int)c + n - 65) % 26 + 65;
                if (newC < 65) {
                    newC += 26;
                }
                c = (char)newC;
            }
            encrypted.setCharAt(i, c);
        }
        return encrypted;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String s = sc.nextLine();
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        Encryptor e = new Encryptor();
        System.out.println(e.encrypt(s, n));
    }
}
