import java.util.Scanner;

/**
 * Converts a number in any base to decimal
 */
class NumberDecimalConverter {
	
    double convert (int base, String num) {
	double decimal = 0.0;
        int j = num.indexOf('.');
        int length = num.length();
        if (j == -1) {
            j = length - 1;
        } else {
            j--;
        }

        for (int i = 0; i < length; i++) {
            char c = num.charAt(i);
            if (Character.isDigit(c)) {
                decimal += Integer.parseInt(c + "") * Math.pow(base, j);
            } else if (c == '.') {
                continue;
            } else {
                decimal += ((int)c - 55) * Math.pow(base, j);
            }
            j--;
        }
	return decimal;
    }

    public static void main () {
        Scanner sc = new Scanner(System.in);
		NumberDecimalConverter dc = new NumberDecimalConverter();
        do {
            System.out.print("Enter the base: ");
            int base = sc.nextInt();
            System.out.print("Enter the number: ");
            String num = sc.next();
            System.out.println(num + " in decimal is: " + dc.convert(base, num));
            System.out.print("Enter \"y\" to continue: ");
        } while (sc.next().equals("y"));
    }
}
