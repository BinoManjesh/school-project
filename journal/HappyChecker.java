package journal;

import java.util.Scanner;

class HappyChecker {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int n = sc.nextInt();
        HappyChecker c = new HappyChecker();

        try {
            if (c.checkIsHappy(n) == -1) {
                System.out.println("happy");
            }
        } catch (StackOverflowError e) {
            System.out.println("sad");
        }
    }

    private int checkIsHappy(int n) {
        if (n == 1) {
            return -1;
        }

        return checkIsHappy(getSqSumOfDigits(n));
    }

    private int getSqSumOfDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
