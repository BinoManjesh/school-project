import java.util.InputMismatchException;
import java.util.Scanner;

class EncryptorDecryptor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EncryptorDecryptor obj = new EncryptorDecryptor();
        printFormatted("");
        printFormatted("ENCRYPTOR/DECRYPTOR");
        printFormatted("");
        boolean end = false;
        while (!end) {
            System.out.println("ENTER:-");
            System.out.println("1: TO ENCRYPT A STRING");
            System.out.println("2: TO DECRYPT A STRING");
            System.out.println("0: TO EXIT");
            try {
                int ch = sc.nextInt();
                sc.nextLine();
                String str, encrypted;
                int key1, key2;
                switch (ch) {
                    case 1:
                        System.out.println("ENTER THE STRING");
                        str = sc.nextLine();
                        key1 = obj.getRandomKey();
                        key2 = obj.getRandomKey();
                        encrypted = obj.encrypt(str, key1, key2);
                        System.out.println("THE ENCRYPTED TEXT:-");
                        System.out.println(encrypted);
                        System.out.println("KEY 1: " + key1);
                        System.out.println("KEY 2: " + key2);
                        break;
                    case 2:
                        System.out.println("ENTER THE STRING");
                        encrypted = sc.nextLine();
                        System.out.print("ENTER KEY 1: ");
                        key1 = sc.nextInt();
                        System.out.print("ENTER KEY 2: ");
                        key2 = sc.nextInt();
                        str = obj.decrypt(encrypted, key1, key2);
                        System.out.println("THE DECRYPTED TEXT:-");
                        System.out.println(str);
                        break;
                    case 0:
                        end = true;
                        printFormatted("");
                        printFormatted("THANK YOU FOR USING THIS PROGRAM");
                        break;
                    default:
                        System.out.println("PLEASE ENTER ONLY 0, 1 OR 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("YOU MAY HAVE ENTERED A STRING WHERE A NUMBER WAS EXPECTED");
                sc = new Scanner(System.in);
            } catch (Exception e) {
                System.out.println("AN UNKNOWN ERROR HAS OCCURRED");
            }
            printFormatted("");
        }
    }

    private static void printFormatted(String s) {
        int padLength = (50 - s.length()) / 2;
        for (int i = 0; i < padLength; i++) {
            System.out.print("*");
        }
        System.out.print(s);
        padLength = 50 - (padLength + s.length());
        for (int i = 0; i < padLength; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private int getRandomKey() {
        return (int) (Math.random() * 512) - 256;
    }

    private String encrypt(String str, int key1, int key2) {
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char newC = (char) (c * c + key1 + i * key2);
            encrypted.append(newC);
        }
        return encrypted.toString();
    }

    private String decrypt(String str, int key1, int key2) {
        StringBuffer decrypted = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char oldC = (char) ((int) Math.sqrt(c - key1 - i * key2));
            decrypted.append(oldC);
        }
        return decrypted.toString();
    }
}
