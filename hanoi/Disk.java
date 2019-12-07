package hanoi;

class Disk {
    
    private static final char BLOCK = '\u2588';

    Disk bottom;
    int size;
    
    Disk(Disk bottom, int size) {
        this.bottom = bottom;
        this.size = size;
    }
    
    void draw(int spaces, int lines, char[][] buffer) {
        for (int i = 0; i < 2 * size - 1; ++i) {
            buffer[lines][spaces + i] = BLOCK;
        }
    }
}
