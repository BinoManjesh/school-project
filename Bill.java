class Bill extends Detail {

    int n;
    double amount;

    Bill(String name, String address, int phoneNumber, double rent, int n) {
        super(name, address, phoneNumber, rent);
        this.n = n;
        amount = 0;
    }

    void calculate() {
        if (n <= 100) {
            amount = rent;
        } else if (n <= 200) {
            amount = rent + 0.06 * n;
        } else if (n <= 300) {
            amount = rent + 0.8 * n;
        } else {
            amount = rent + n;
        }
    }

    void show() {
        super.show();
        System.out.println("Amount: " + amount);
    }
}
