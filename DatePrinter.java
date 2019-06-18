import java.util.Scanner;

class DatePrinter {

    int day;
    int month;
    int year;

    DatePrinter () {
        day = 0;
        month = 0;
        year = 0;
    }

    DatePrinter (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    void print () {
        System.out.println(day + "/" + month + "/" + year);
    }

    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the day: ");
        int day = sc.nextInt();
        System.out.print("Enter the month: ");
        int month = sc.nextInt();
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        
        DatePrinter dp = new DatePrinter(day, month, year);
        dp.print();
    }
}
