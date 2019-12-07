package hanoi;

class Stack {

    static int maxDisks;
    Disk top;
    int disks;

    Stack(boolean fill) {
        disks = 0;
        if (fill == true) {
            int size = maxDisks;
            while (size > 0) {
                top = new Disk(top, size);
                ++disks;
                --size;
            }
        }
    }

    // Moves the topmost disk in this Stack to s
    void moveTop(Stack s) {
        Disk newTop = this.top.bottom;
        this.top.bottom = s.top;
        s.top = this.top;
        this.top = newTop;
        --disks;
        ++s.disks;
    }
    
    void draw(int offset, char[][] buffer) {
        Disk disk = top;
        int lines = maxDisks - disks;
        while (disk != null) {
            int spaces = offset + maxDisks - disk.size;
            disk.draw(spaces, lines, buffer);
            ++lines;
            disk = disk.bottom;
        }
    }
}
