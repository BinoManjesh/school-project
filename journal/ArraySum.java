package journal;

import java.util.*;

class ArraySum {
    
    int[] getSum(int[] arr1, int[] arr2) {
        int[] sum = new int[5];
        for (int i = 0; i < 5; ++i) {
            sum[i] = arr1[i] + arr2[i];
        }
        return sum;
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[5];
        System.out.println("Enter array 1:-");
        for (int i = 0; i < 5; ++i) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[5];
        System.out.println("Enter array 2:-");
        for (int i = 0; i < 5; ++i) {
            arr2[i] = sc.nextInt();
        }
        ArraySum obj = new ArraySum();
        int[] sum = obj.getSum(arr1, arr2);
        System.out.println("The sums are:-");
        for (int i = 0; i < 5; ++i) {
            System.out.print(sum[i] + " ");
        }
    }
}
