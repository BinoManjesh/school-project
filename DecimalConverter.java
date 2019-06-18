import java.util.Scanner;

//Converts a number in any base to base 10
class DecimalConverter {

    int base;
    String num;
    double decimal;

    DecimalConverter (int base, String num) {
        this.base = base;
        this.num = num;
        decimal = 0.0;
    }

    void calculate () {
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
    }

    void print () {
        System.out.println("Decimal: " + decimal);
    }

    public static void main () {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the base: ");
            int base = sc.nextInt();
            System.out.print("Enter the number: ");
            String num = sc.next();

            DecimalConverter dc = new DecimalConverter(base, num);
            dc.calculate();
            dc.print();

            System.out.print("Enter \"y\" to continue: ");
        } while (sc.next().equals("y"));
    }
}
