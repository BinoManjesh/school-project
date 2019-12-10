package class12.year_2017;

import java.util.Scanner;

class BoxPacker {
    
    void displayPacking(int n) {
        int boxSize = 48;
        while (boxSize >= 6) {
            int numBoxes = n / boxSize;
            System.out.println(boxSize + " x " + numBoxes);
            n -= numBoxes;
            boxSize /= 2;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoxPacker obj = new BoxPacker();
        System.out.println("Enter number of boxes:-");
        int n = sc.nextInt();  
        obj.displayPacking(n);
    }
}
