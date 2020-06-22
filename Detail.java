class Detail {

    String name;
    String address;
    int phoneNumber;
    double rent;

    Detail(String name, String address, int phoneNumber, double rent) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rent = rent;
    }

    void show() {
        System.out.println("Name: " + name +
                "\nAddress: " + address +
                "\nTelephone number: " + phoneNumber +
                "\nRent: " + rent);
    }
}
