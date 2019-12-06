package journal;

import java.util.*;

class MaxFinder {
    
    int getMaxPos(int[] arr) {
        int max = arr[0], maxPos = 0;
        for (int i = 1; i < 10; ++i) {
            if (arr[i] > max) {
                max = arr[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[10];
        System.out.println("Enter the marks:-");
        for (int i = 0; i < 10; ++i) {
            marks[i] = sc.nextInt();
        }
        String[] names = new String[10];
        System.out.println("Enter the names:-");
        for (int i = 0; i < 10; ++i) {
            names[i] = sc.next();
            System.out.println(i+ ": " + names[i]);
        }
        MaxFinder obj = new MaxFinder();
        int pos = obj.getMaxPos(marks);
        System.out.println(names[pos] + " has the highest marks.");
    }
}
