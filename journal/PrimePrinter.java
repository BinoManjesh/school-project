package journal;

import java.util.*;

class PrimePrinter {
    
    boolean isPrime(int n) {
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
        
    void printPrimes(int[] arr) {
        System.out.println("The primes are:-");
        for (int i = 0; i < arr.length; ++i) {
            if (isPrime(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array:-");
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        PrimePrinter p = new PrimePrinter();
        p.printPrimes(arr);
    }
}
