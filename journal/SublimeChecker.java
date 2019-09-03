package journal;

import java.util.Scanner;

class SublimeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        SublimeChecker c = new SublimeChecker();
        if (c.isSublime(n)) {
            System.out.println(n + " is sublime.");
        } else {
            System.out.println(n + " is not sublime.");
        }

    }

    private boolean isSublime(int n) {
        int sum = 0;
        int noOfDivisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                noOfDivisors++;
            }
        }
        return isPerfect(sum) && isPerfect(noOfDivisors);
    }

    private boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
