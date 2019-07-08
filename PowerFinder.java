import java.util.Scanner;

class PowerFinder {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base: ");
        double base = sc.nextDouble();
        System.out.print("Enter the power: ");
        double power = sc.nextDouble();

        PowerFinder f = new PowerFinder();
        System.out.println(base + "^" + power + " is: " + f.getPow(base, power));
    }

    double getPow(double base, double power) {
        if (power == 0) {
            return 1;
        }
        if (power > 0) {
            base = getPow(base, --power) * base;
        } else {
            base = getPow(base, ++power) / base;
        }
        return base;
    }
}
