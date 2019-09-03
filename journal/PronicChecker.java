package journal;

import java.util.Scanner;

class PronicChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        PronicChecker c = new PronicChecker();
        if (c.isPronic(n)) {
            System.out.println(n + " is a pronic number.");
        } else {
            System.out.println(n + " is not a pronic number");
        }
    }

    private boolean isPronic(int n) {
        for (int i = 2; i < n; i++) {
            if (n == i * (i - 1)) {
                return true;
            }
        }
        return false;
    }
}
