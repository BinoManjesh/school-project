import java.util.Scanner;

class NumSorter {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        NumSorter s = new NumSorter();
        System.out.println(s.sort(n));
    }

    int sort(int n) {
        int sorted = 0;
        while (n > 0) {
            int digit = n % 10;
            int c = sorted;
            int power = 1;
            while (c > 0) {
                if (digit >= c % 10) {
                    sorted = (c % 10 * power + digit) * power + sorted - (c % 10 * power);
                    break;
                }
                power *= 10;
                c /= 10;
            }
            n /= 10;
        }
        return sorted;
    }
}
