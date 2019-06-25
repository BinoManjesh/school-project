package journal;

import java.util.Scanner;

/**
 * 3. Write a program to accept a number and check if it is a Smith number
 */
class SmithChecker {

    boolean check (int n) {
        int sumOfPrimes = 0;
        int c = n;
        for (int i = 2; i < c; i++) {
            while (n % i == 0) {
                n /= i;
                sumOfPrimes += getSumOfDigits(i);
            }
        }
        return sumOfPrimes == getSumOfDigits(n);
    }
    
    int getSumOfDigits (int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10; 
            n /= 10;
        }
        return sum;
    }

    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        SmithChecker c = new SmithChecker();
        assert c.getSumOfDigits(26) == 8;
        assert c.getSumOfDigits(2) == 2;
        System.out.println(c.check(n));
    }
}
