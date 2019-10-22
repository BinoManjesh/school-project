package art;

import java.awt.*;

class WeirdSquare extends Canvas {

    private static final int SIZE = 729;
    private static final int RECURSIONS = 3;

    private WeirdSquare() {
        super(SIZE, SIZE);
    }

    public static void main(String[] args) {
        new WeirdSquare();
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(0, 0, SIZE, RECURSIONS, g);
    }

    private void draw(int x, int y, int size, int recursions, Graphics graphics) {
        if (recursions == 0) {
            graphics.fillRect(x, y, size, size);
            return;
        }
        int newSize = size / 3;
        recursions--;
        draw(x, y, newSize, recursions, graphics);
        draw(x + newSize * 2, y, newSize, recursions, graphics);
        draw(x + newSize * 2, y + newSize * 2, newSize, recursions, graphics);
        draw(x + newSize, y + newSize, newSize, recursions, graphics);
        draw(x, y + newSize * 2, newSize, recursions, graphics);
        //        draw(x + newSize, y + newSize * 2, newSize, recursions, graphics);
    }
}
