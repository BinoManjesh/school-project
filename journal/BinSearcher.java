package journal;

import java.util.*;

class BinSearcher {
    
    int search(int[] arr, int key, int start, int end) {
        if (end < start) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (key < arr[mid]) {
            return search(arr, key, start, mid);
        } else if (arr[mid] < key) {
            return search(arr, key, mid + 1, end);
        } else {
            return mid;
        }
    }
    
    void search(int[] arr, int key) {
        int index = search(arr, key, 0, arr.length);
        if (index == -1) {
            System.out.println(key + " is not in the array.");
        } else {
            System.out.println(key + " is at " + index);
        }
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the sorted array elements:-");
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the search element: ");
        int key = sc.nextInt();
        
        BinSearcher obj = new BinSearcher();
        obj.search(arr, key);
    }
}
