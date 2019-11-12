package hanoi;

class Mover {

    private Stack[] stacks;

    Mover(Stack[] stacks) {
        this.stacks = stacks;
    }

    // Moves the topmost n disks from s1 to s2
    void move(Stack s1, Stack s2, int n) {
        if (n != 0) {
            Stack spare = getSpare(s1, s2);
            move(s1, spare, n - 1);
            s1.moveTop(s2);
            move(spare, s2, n - 1);
        }
    }

    // Returns a stack that is not s1 or s2
    private Stack getSpare(Stack s1, Stack s2) {
        for (Stack stack : stacks) {
            if (stack != s1 && stack != s2) {
                return stack;
            }
        }
        // This will never return null
        return null;
    }
}
