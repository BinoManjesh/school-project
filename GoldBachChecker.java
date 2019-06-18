import java.util.Scanner;

class GoldBachChecker {
    
    int n;
    
    GoldBachChecker (int n) {
        this.n = n;
    }
    
    boolean check() {
        return false;
    }
    
    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        GoldBachChecker c = new GoldBachChecker(n);
        if (c.check()) {
            System.out.print(n + " is a Gold Bach number");
        } else {
            System.out.print(n + " is not a Gold Bach number");
        }
    }
}
