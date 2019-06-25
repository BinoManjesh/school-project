import java.util.Scanner;

class AutomorphicChecker {
    
    boolean check (int n) {
        int square = n * n;
        String sq = square + "";
        return sq.endsWith(n + "");
    }
    
    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        AutomorphicChecker c = new AutomorphicChecker();
        System.out.println(c.check(n));
    }
}
