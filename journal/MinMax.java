package journal;

import java.util.*;

class MinMax {
    
    void printMinMax(int[][] mat) {
        int min = mat[0][0];
        int max = mat[0][0];
        for (int i = 0; i < 3; ++i) {
            for (int  j = 0; j < 3; ++j) {
                min = Math.min(min, mat[i][j]);
                max = Math.max(max, mat[i][j]);
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int[][] mat = new int[3][3];
        System.out.println("Enter the matrix:-");
        for (int  i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                mat[i][j] = sc.nextInt();
            }
        }
        MinMax obj = new MinMax();
        obj.printMinMax(mat);
    }
}
