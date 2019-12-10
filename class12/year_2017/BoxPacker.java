package class12.year_2017;

import java.util.Scanner;

class BoxPacker {
    
    void displayPacking(int n) {
        int boxSize = 48, total = n, totalCartons = 0;
        while (boxSize >= 6) {
            int numBoxes = n / boxSize;
            int cartons = numBoxes * boxSize;
            if (numBoxes != 0) {
                System.out.println("\t" + boxSize + " X " + numBoxes + " = " + cartons);
                totalCartons += numBoxes;
            }
            n -= numBoxes * boxSize;
            boxSize /= 2;
        }
        System.out.println("Remaining boxes\t= " + n + " X 1" +
        "\nTotal number of boxes\t= " + total +
        "\nTotal number of cartons\t= " + totalCartons);
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoxPacker obj = new BoxPacker();
        System.out.print("Enter number of boxes:\t");
        int n = sc.nextInt();  
        obj.displayPacking(n);
    }
}
