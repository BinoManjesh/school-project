package art;

import java.awt.*;

class WeirdCircle extends Canvas {

    private static final int RECURSIONS = 6;

    public static void main(String[] args) {
        new WeirdCircle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(0, 0, Math.min(getWidth(), getHeight()), g, RECURSIONS);
    }

    private void draw(double x, double y, double size, Graphics g, int recursions) {
        if (recursions == 0) {
            return;
        }
        g.drawOval((int) x, (int) y, (int) size, (int) size);
        double newSize = size / 2;
        recursions--;
        draw(x + newSize / 2, y, newSize, g, recursions);
        draw(x + newSize / 2, y + size / 2, newSize, g, recursions);
        draw(x + newSize, y + newSize / 2, newSize, g, recursions);
        draw(x, y + newSize / 2, newSize, g, recursions);
    }
}
