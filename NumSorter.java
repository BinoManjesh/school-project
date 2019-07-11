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
            int dig1 = n % 10;
            int pos = getPos(dig1, sorted);
            sorted = insert(dig1, pos, sorted);
            n /= 10;
        }
        return sorted;
    }

    private int getPos(int n, int target) {
        int i = 0;
        do {
            int dig = target % 10;
            if (n > dig) {
                return i;
            }
            i++;
            target /= 10;
        } while (target > 0);
        return i;
    }

    private int insert(int n, int i, int target) {
        return (target / (int) Math.pow(10, i)) * (int) Math.pow(10, i + 1) + n * (int) Math.pow(10, i) + target % (int) Math.pow(10, i);
    }
}
