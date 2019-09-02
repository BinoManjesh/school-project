package journal;

class FactorialPrinter {

    public static void main(String[] args) {
        FactorialPrinter p = new FactorialPrinter();
        p.print();
    }

    private void print() {
        for (int i = 1; i < 1000; i++) {
            System.out.println(getFact(i));
        }
    }

    private double getFact(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
