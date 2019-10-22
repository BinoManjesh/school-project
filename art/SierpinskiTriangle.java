package art;

import java.awt.*;

class SierpinskiTriangle extends Canvas {

    private static final int SIZE = 512;
    private static final int MIN_SIZE = 1;

    public static void main(String[] args) {
        new SierpinskiTriangle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(0, 0, SIZE, g);
    }

    private void draw(int x, int y, int size, Graphics g) {
        int newSize = size / 2;
        if (newSize <= MIN_SIZE) {
            g.fillRect(x, y, size, size);
        } else {
            draw(x, y, newSize, g);
            draw(x + newSize, y, newSize, g);
            draw(x, y + newSize, newSize, g);
        }
    }
}
