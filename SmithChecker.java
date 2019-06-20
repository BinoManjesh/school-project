import java.util.Scanner;

/**
 * Checks if a number is a Smith number. A Smith number is a number whose sum of didits equals the sum of digits of its prime factors
 */
class SmithChecker {

    boolean check (int n) {
        int sumOfN = getSumOfDigits(n);
        int sumOfPrimes = 0;
        int c = n;
        for (int i = 2; i < c; i++) {
            while (n % i == 0) {
                n /= i;
                sumOfPrimes += getSumOfDigits(i);
            }
        }
        System.out.println(sumOfN);
        System.out.println(sumOfPrimes);
        return sumOfPrimes == sumOfN;
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
