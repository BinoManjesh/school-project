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
        if (n == 1) {
            return 1;
        }
        return n * getFact(n - 1);
    }
}
