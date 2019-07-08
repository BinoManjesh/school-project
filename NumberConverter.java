import java.util.Scanner;

class NumberConverter {

    NumberDecimalConverter ndc;
    DecimalNumberConverter dnc;

    NumberConverter() {
        ndc = new NumberDecimalConverter();
        dnc = new DecimalNumberConverter();
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        NumberConverter c = new NumberConverter();
        do {
            System.out.print("Enter a number: ");
            String num = sc.next();
            System.out.print("Enter its base: ");
            int base = sc.nextInt();
            System.out.print("Enter the target base: ");
            int targetBase = sc.nextInt();
            System.out.println(num + " in base " + targetBase + " is: " + c.convert(num, base, targetBase));
        } while (true);
    }

    String convert(String num, int base, int targetBase) {
        return dnc.convert(ndc.convert(base, num), targetBase);
    }
}
