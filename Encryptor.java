import java.util.Scanner;

class Encryptor {

    private static final int A = 3;
    private static final int C = 4264;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:-");
        String str = sc.nextLine();
        System.out.println("Enter 0 to encrypt and 1 to decrypt:\t");
        byte ch = sc.nextByte();
        Encryptor e = new Encryptor();
        if (ch == 0) {
            System.out.println(e.encrypt(str));
        } else if (ch == 1) {
            System.out.println(e.decrypt(str));
        }
    }

    private String encrypt(String str) {
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char newC = (char) (A * c * c + C + i);
            encrypted.append(newC);
        }
        return encrypted.toString();
    }

    private String decrypt(String str) {
        StringBuffer decrypted = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char newC = (char) ((int) Math.sqrt((c - C - i) / A));
            decrypted.append(newC);
        }
        return decrypted.toString();
    }
}
