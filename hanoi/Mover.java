package hanoi;

class Mover {

    private Stack[] stacks;
    
    private final int STACK_WIDTH;
    private final int LINES;
    private final int SPACES;

    Mover(Stack[] stacks) {
        this.stacks = stacks;
        STACK_WIDTH = 2 * Stack.maxDisks - 1;
        LINES = Stack.maxDisks;
        SPACES = 3 * STACK_WIDTH + 2;
    }

    // Moves the topmost n disks from s1 to s2
    void move(Stack s1, Stack s2, int n) {
        if (n != 0) {
            Stack spare = getSpare(s1, s2);
            move(s1, spare, n - 1);
            s1.moveTop(s2);
            show();
            move(spare, s2, n - 1);
        }
    }
    
    private void show() {
        char[][] buffer = new char[LINES][SPACES];
        for (int i = 0; i < LINES; ++i) {
            for (int j = 0; j < SPACES; ++j) {
                buffer[i][j] = '\u2591';
            }
        }
        for (int i = 0; i < 3; ++i) {
            stacks[i].draw(i * (STACK_WIDTH + 1), buffer);
        }
        StringBuffer stringBuffer = new StringBuffer(LINES*SPACES);
        for (char[] row : buffer) {
            stringBuffer.append(row);
            stringBuffer.append('\n');
        }
        System.out.println(stringBuffer);
    }

    // Returns a stack that is not s1 or s2
    private Stack getSpare(Stack s1, Stack s2) {
        for (Stack stack : stacks) {
            if (stack != s1 && stack != s2) {
                return stack;
            }
        }
        // This will never return null as there will always be a Stack that is not s1 or s2
        return null;
    }
}
