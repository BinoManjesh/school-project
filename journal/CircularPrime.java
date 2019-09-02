package journal;

import java.util.Scanner;

class CircularPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        CircularPrime obj = new CircularPrime();
        if (obj.isCircularPrime(n)) {
            System.out.println(n + " is a circular prime number.");
        } else {
            System.out.println(n + " is not a circular prime number.");
        }
    }

    private boolean isCircularPrime(int n) {
        if (isNotPrime(n)) {
            return false;
        }
        StringBuffer buff = new StringBuffer("" + n);
        for (int i = 0; i < buff.length(); i++) {
            char c = buff.charAt(0);
            buff.deleteCharAt(0);
            buff.append(c);
            if (isNotPrime(Integer.valueOf(buff.toString()))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotPrime(int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
