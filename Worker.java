class Worker {

    String name;
    double basic;

    Worker(String name, double basic) {
        this.name = name;
        this.basic = basic;
    }

    void display() {
        System.out.println("Name: " + name +
                "\nBasic: " + basic);
    }
}

class Wages extends Worker {

    double hours, rate, wage;

    Wages(String name, double basic, double hours, double rate) {
        super(name, basic);
        this.hours = hours;
        this.rate = rate;
        wage = 0;
    }

    double overtime() {
        return hours * rate;
    }

    void display() {
        super.display();
        wage = overtime() + basic;
        System.out.println("Wage: " + wage);
    }
}
