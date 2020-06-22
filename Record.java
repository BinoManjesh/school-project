import java.util.Scanner;

class Record {

    String[] name;
    int[] rnk;

    Record() {
        name = new String[50];
        rnk = new int[50];
    }

    void readvalues() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        System.out.println("Enter the names of the students:-");
        for (int i = 0; i < 50; i++) {
            name[i] = sc.nextLine();
        }
        System.out.println("Enter the ranks of the students:-");
        for (int i = 0; i < 50; i++) {
            rnk[i] = sc.nextInt();
        }
    }

    void display() {
        System.out.println("Name\tRecord.Rank");
        for (int i = 0; i < 50; i++) {
            System.out.println(name[i] + "\t" + rnk[i]);
        }
    }
}

class Rank extends Record {

    int index;

    Rank() {
        super();
        index = 0;
    }

    void highest() {
        int highestRank = rnk[0];
        for (int i = 1; i < 50; i++) {
            if (rnk[i] > highestRank) {
                index = i;
                highestRank = rnk[i];
            }
        }
    }

    void display() {
        super.display();
        System.out.println("Highest ranked student:\t" + name[index]);
    }
}
