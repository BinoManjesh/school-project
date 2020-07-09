import java.util.Scanner;

class SubsetSum {

    int[] array;
    int n;
    int k;

    public static void main(String[] args) {
        SubsetSum obj = new SubsetSum();
        obj.accept();
        obj.printSubsets();
    }

    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE SIZE OF THE ARRAY: ");
        n = sc.nextInt();
        array = new int[n];
        System.out.println("ENTER THE ARRAY:-");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.print("ENTER THE SUM: ");
        k = sc.nextInt();
    }

    void printSubsets() {
        for (int subset = 0; subset < Math.pow(2, n); subset++) {
            int copy = subset, sum = 0, i = 0;
            String output = "";
            while (copy > 0) {
                if (copy%2 == 1) {
                    sum += array[i];
                    output += array[i] + " + ";
                }
                copy /= 2;
                i++;
            }
            if (sum == k)
                System.out.println(output + "\b\b\b = " + k);
        }
    }
}

/*
6
2 3 5 6 8 10
10

 */
