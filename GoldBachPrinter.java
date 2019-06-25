import java.util.Scanner;

/**
 * Accepts a number and prints all the ways it can be expressed as the sum of 2 odd prime numbers
 */ 
class GoldBachPrinter {
	
    void print (int n) {
        for (int i = 2; i <= n / 2; i ++) {
            if (checkIfOddPrime(i) && checkIfOddPrime(n - i)) {
                System.out.println(i + " + " + (n - i));
            }
        }
    }
    
    boolean checkIfOddPrime (int n) {
	// 2 is the only even prime number
        if (n == 1 || n == 2) {
            return false;
        }
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
        
        GoldBachPrinter c = new GoldBachPrinter();
        assert !c.checkIfOddPrime(2);
        assert c.checkIfOddPrime(7);
        assert !c.checkIfOddPrime(4);
	    c.print(n);
    }
}
