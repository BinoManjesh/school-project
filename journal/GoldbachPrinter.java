package journal;

import java.util.Scanner;

/**
 * 4. Write a program to accept a number and print all the ways it can be expressed as a Goldbach number. A Goldbach number is a number that is the sum of two odd primes
 */ 
class GoldbachPrinter {
	
    void print (int n) {
        for (int i = 3; i <= n / 2; i ++) {
            if (checkIfPrime(i) && checkIfPrime(n - i)) {
                System.out.println(i + " + " + (n - i));
            }
        }
    }
    
    boolean checkIfPrime (int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main () {    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        GoldbachPrinter c = new GoldbachPrinter();
	c.print(n);
    }
}
