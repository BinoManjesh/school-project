import java.util.Scanner;

class MergeSorter {
    
    //Merges the portion of the array between (start and mid) and (mid and end)
    static void merge(int[] a, int start, int mid, int end) {
        int i = start, j = mid, k = 0;
        //Stores the merged version of the portion between start and end 
        int[] temp = new int[end - start];
        while(k < end - start) {
            if (i < mid && (j >= end || a[i] < a[j])) {
                temp[k++] = a[i++];
            }
            if (j < end && (i >= mid || a[j] < a[i])) {
                temp[k++] = a[j++];
            }
        }
        //Copies temp on the portion of a between start and end
        for (int l = 0; l < end - start; l++) {
            a[start + l] = temp[l];
        } 
    }
    
    //Sorts the portion of the array between i and j (inclusive and exclusive)
    //Until merging, this algorithm is in place.
    static void mergeSort(int[] a, int start, int end) {
        //Base case
        if (end - start <= 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid, end);
        merge(a, start, mid, end);
    }
    
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the array:-");
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        mergeSort(a, 0, a.length);
        for (int i = 0; i < n; ++i) {
            System.out.print(a[i] + ' ');
        }
    }
}