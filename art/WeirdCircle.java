package art;

import java.awt.*;

class WeirdCircle extends Canvas {

    private static final int SIZE = 512;
    private static final int RECURSIONS = 3;

    public static void main(String[] args) {
        new WeirdCircle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(0, 0, SIZE, g, RECURSIONS);
    }

    private void draw(int x, int y, int size, Graphics g, int recursions) {
        if (recursions == 0) {
            return;
        }
        g.drawOval(x, y, size, size);
        int newSize = size / 2;
        recursions--;
        draw(x + newSize / 2, y, newSize, g, recursions);
        draw(x + newSize / 2, y + size / 2, newSize, g, recursions);
        draw(x + newSize, y + newSize / 2, newSize, g, recursions);
        draw(x, y + newSize / 2, newSize, g, recursions);
    }
}
