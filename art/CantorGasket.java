package art;

import java.awt.*;

class CantorGasket extends Canvas {

    private static final int SIZE = 343;
    private static final int RECURSIONS = 2;

    private CantorGasket() {
        super(SIZE, SIZE);
    }

    public static void main(String[] args) {
        new CantorGasket();
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
        for (int i = 0; i < 9; i++) {
            if (i == 4) {
                continue;
            }
            draw(x + newSize * (i / 3), y + newSize * (i % 3), newSize, recursions, graphics);
        }
    }
}
