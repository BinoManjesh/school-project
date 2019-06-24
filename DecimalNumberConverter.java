import java.util.Scanner;

class DecimalNumberConverter {
    
    String convert (double n, int targetBase) {
        String num = "";
        double fraction = n - (int)n;
        int intN = (int)(n - fraction);
        while (intN > 0) {
            if (intN % targetBase > 9) {
                int i = intN % targetBase + 55;
                num = (char)(i) + num;
            } else {
                num = (intN % targetBase) + num;
            }
            
            intN = intN / targetBase;
        }
        String fractional = "";
        while (fraction != 0) {
            fraction *= targetBase;
            fractional += (int)fraction;
            fraction -= (int)fraction;
        }
        return num + "." + fractional;
    }
    
    public static void main () {
        Scanner sc = new Scanner(System.in);
        DecimalNumberConverter c = new DecimalNumberConverter();
        do {
            System.out.print("Enter a number in decimal: ");
            double n = sc.nextDouble();
            System.out.print("Enter the target base: ");
            int targetBase = sc.nextInt();
            System.out.println(c.convert(n, targetBase));
            System.out.println("Enter \"y\" to continue");
        } while (sc.next().equals("y"));
    }
}
