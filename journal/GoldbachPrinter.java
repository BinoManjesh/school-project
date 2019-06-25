package journal;

import java.util.Scanner;

/**
 * 4. Write a program to accept a number and print all the ways it can be expressed as a Goldbach number
 */ 
class GoldbachPrinter {
	
    void print (int n) {
        for (int i = 2; i <= n / 2; i ++) {
            if (checkIfOddPrime(i) && checkIfOddPrime(n - i)) {
                System.out.println(i + " + " + (n - i));
            }
        }
    }
    
    boolean checkIfOddPrime (int n) {
        for (int i = 1; i < n; i++) {
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
        assert !c.checkIfOddPrime(2);
        assert c.checkIfOddPrime(7);
        assert !c.checkIfOddPrime(4);
	    c.print(n);
    }
}
