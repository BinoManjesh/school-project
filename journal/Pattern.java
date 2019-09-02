package journal;

import java.util.Scanner;

class Pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter \'a\' or  \'b\': ");
        char ch = Character.toLowerCase(sc.next().charAt(0));
        Pattern obj = new Pattern();
        switch (ch) {
            case 'a':
                obj.patternA(n);
                break;
            case 'b':
                obj.patternB(n);
                break;
            default:
                System.out.println("Please enter only \'a\' or \'b\'");
        }
    }

    private void patternA(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private void patternB(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                System.out.print((j < i) ? i : j);
            }
            System.out.println();
        }
    }
}
