import java.util.Scanner;

class GoldBachChecker {
    
    int n;
    
    GoldBachChecker (int n) {
        this.n = n;
    }
    
    boolean check () {
        for (int i = 2; i < n; i ++) {
            if (checkIfOddPrime(i)) {
                if (checkIfOddPrime(n - i)) {
                    return true;
                }
            }
        }
        return false;
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
        
        GoldBachChecker c = new GoldBachChecker(n);
        assert c.checkIfOddPrime(2);
        assert c.checkIfOddPrime(7);
        assert !c.checkIfOddPrime(4);
        if (c.check()) {
            System.out.print(n + " is a Gold Bach number");
        } else {
            System.out.print(n + " is not a Gold Bach number");
        }
    }
}
