package journal;

import java.util.Scanner;

class SmallLarge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        SmallLarge obj = new SmallLarge();
        obj.printSmallLarge(n);
    }

    private void printSmallLarge(int n) {
        StringBuffer smallest = new StringBuffer(n + "");
        for (int i = 0; i < smallest.length(); i++) {
            int min = Integer.parseInt(smallest.charAt(i) + "");
            int minPos = i;
            for (int j = i; j < smallest.length(); j++) {
                int digit = Integer.parseInt(smallest.charAt(j) + "");
                if (digit < min) {
                    min = digit;
                    minPos = j;
                }
            }
            char temp = smallest.charAt(i);
            smallest.setCharAt(i, (min + "").charAt(0));
            smallest.setCharAt(minPos, temp);
        }
        System.out.println(smallest);
        System.out.println(smallest.reverse());
    }
}
