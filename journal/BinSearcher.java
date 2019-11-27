package journal;

import java.util.*;

class BinSearcher {
    
    int[] arr;
    int key;
    
    BinSearcher() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter the sorted array elements:-");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the ");
    }
    
    void search(int key) {
        int index = search(key, 0, arr.length() - 1);
        if (index = -1) {
            System.out.println(key + " not found.");
        } else {
            
        }
    }
    
    int search(int key, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (key < arr[mid]) {
            return search(key, start, mid);
        } else if (arr[mid] < key) {
            return search(key, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static void main() {
        
        BinSearcher obj = new BinSearcher(n);
        obj.accept(sc);
    }
}
