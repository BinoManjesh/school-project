package journal;

import java.util.*;

class MinMax {
    
    int[][] mat;
    
    MinMax() {
        mat = new int[3][3];
    }
    
    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the matrix:-\n");
        for (int  i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }
    
    void printMinMax() {
        int min = mat[0][0];
        int max = mat[0][0];
        for (int i = 0; i < 3; i++) {
            for (int  j = 0; j < 3; j++) {
                min = Math.min(min, mat[i][j]);
                max = Math.max(max, mat[i][j]);
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
    
    public static void main() {
        MinMax obj = new MinMax();
        obj.accept();
        obj.printMinMax();
    }
}
