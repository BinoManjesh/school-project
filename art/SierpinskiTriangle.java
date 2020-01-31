package art;

import java.awt.*;

class SierpinskiTriangle extends Canvas {

    private static final int SIZE = 512;
    private static final int RECURSIONS = 10;

    public static void main(String[] args) {
        new SierpinskiTriangle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(0, 0, SIZE, g, RECURSIONS);
    }

    private void draw(int x, int y, int size, Graphics g, int recursions) {
        if (recursions == 1) {
            g.fillRect(x, y, size, size);
        } else {
            int newSize = size / 2;
            draw(x, y, newSize, g, recursions - 1);
            draw(x + newSize, y, newSize, g, recursions - 1);
            draw(x, y + newSize, newSize, g, recursions - 1);
        }
    }
}
