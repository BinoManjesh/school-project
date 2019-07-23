package journal;

import java.util.Scanner;

class Encryptor {

    private String encrypt(String s, int n) {
        String encrypted = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isUpperCase(c)) {
                int newC = ((int)c + n - 65) % 26;
            }
            else if(Character.isLowerCase(c)) {

            } else {
                encrypted += c;
            }
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
