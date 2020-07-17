import java.util.Scanner;

class NumberToFraction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();

        int nStart = 0, dStart = 1;
        int nEnd = 1, dEnd = 1;
        int nMid = nStart + nEnd;
        int dMid = dStart + dEnd;

        final int iterations = 1000000;

        for (int i = 0; i < iterations; i++) {
            nMid = nStart + nEnd;
            dMid = dStart + dEnd;
            if (num < 1.0*nMid/dMid) {
                nEnd = nMid;
                dEnd = dMid;
            } else if (1.0*nMid/dMid < num) {
                nStart = nMid;
                dStart = dMid;
            } else {
                break;
            }
        }
        System.out.printf("%d/%d = %f", nMid, dMid, (double) nMid/dMid);
    }
}
