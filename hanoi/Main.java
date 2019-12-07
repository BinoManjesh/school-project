package hanoi;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = sc.nextInt();
        Stack.maxDisks = n;
        Stack[] stacks = new Stack[3];
        stacks[0] = new Stack(true);
        stacks[1] = new Stack(false);
        stacks[2] = new Stack(false);
        Mover mover = new Mover(stacks);
        mover.move(stacks[0], stacks[2], n);
    }
}
