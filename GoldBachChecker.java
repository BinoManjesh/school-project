import java.util.Scanner;

class GoldBachChecker {
    
    int n;
    
    GoldBachChecker (int n) {
        this.n = n;
    }
    
    boolean check () {
        for (int i = 2; i < n; i ++) {
            if (checkIsPrime(i)) {
                if (checkIsPrime(n - i)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean checkIsPrime (int n) {
        if (n == 1) {
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
        assert c.checkIsPrime(2);
        assert c.checkIsPrime(7);
        assert !c.checkIsPrime(4);
        if (c.check()) {
            System.out.print(n + " is a Gold Bach number");
        } else {
            System.out.print(n + " is not a Gold Bach number");
        }
    }
}
