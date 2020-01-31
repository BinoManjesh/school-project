package art;

import java.awt.*;

class SierpinskiTriangle extends Canvas {

    public static void main(String[] args) {
        new SierpinskiTriangle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth(), height = getHeight();
        int p = (int) (Math.log(Math.min(width, height)) / Math.log(2));
        int size = (int) Math.pow(2, p);
        System.out.println(size);
        draw(0, 0, size, g);
    }

    private void draw(int x, int y, int size, Graphics g) {
        if (size == 1) {
            g.fillRect(x, y, size, size);
        } else {
            int newSize = size / 2;
            draw(x, y, newSize, g);
            draw(x + newSize, y, newSize, g);
            draw(x, y + newSize, newSize, g);
        }
    }
}
