package journal;

import java.util.Scanner;

class NumSorter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        NumSorter s = new NumSorter();
        System.out.println(s.sort(n));
    }

    private int sort(int n) {
        int sorted = 0;
        while (n > 0) {
            int c = n;
            int max = c % 10;
            int pos = 0;
            int maxPos = 0;
            while (c > 0) {
                int digit = c % 10;
                if (digit > max) {
                    max = digit;
                    maxPos = pos;
                }
                c /= 10;
                pos++;
            }
            sorted = sorted * 10 + max;
            int power = (int) Math.pow(10, maxPos + 1);
            n = (n / power) * power + n % (power / 10);
        }
        return sorted;
    }
}
