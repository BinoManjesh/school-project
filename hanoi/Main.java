package hanoi;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int n = sc.nextInt();
        Stack[] stacks = new Stack[3];
        stacks[0] = new Stack(n);
        stacks[1] = new Stack(n);
        stacks[2] = new Stack(n);
        Mover mover = new Mover(stacks);
        mover.move(stacks[0], stacks[2], n);
    }
}
