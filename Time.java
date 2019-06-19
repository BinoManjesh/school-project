import java.util.Scanner;

/**
 * Accepts two times and prints their sum
 */
class Time {
    
    int hrs;
    int mins;
    
    Time (int hrs, int mins) {
        input(hrs, mins);
    }
    
    void input (int hrs, int mins) {
        this.hrs = hrs;
        this.mins = mins;
    }
    
    void display () {
        System.out.println(hrs + " hours, " + mins + " mins");
    }
    
    void addTime (Time t1, Time t2) {
        int totalMins = (t1.hrs + t2.hrs) * 60 + t1.mins + t2.mins;
        hrs = totalMins / 60;
        mins = totalMins % 60;
    }
    
    public static void main () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hours for t1: ");
        int hrs1 = sc.nextInt();
        System.out.print("Enter minutes for t1: ");
        int mins1 = sc.nextInt();
        System.out.print("Enter hours for t2: ");
        int hrs2 = sc.nextInt();
        System.out.print("Enter minutess for t2: ");
        int mins2 = sc.nextInt();
        
        Time t1 = new Time(hrs1, mins1);
        Time t2 = new Time(hrs2, mins2);
    }
}
