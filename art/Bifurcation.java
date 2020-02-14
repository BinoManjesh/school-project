package art;

import java.awt.*;
import java.awt.event.KeyEvent;

class Bifurcation extends Plot {

    private static final int depth = 500;

    private double moe = 0.001;

    private Bifurcation() {
        super(800, 200);
        camX = 2;
        scale = 4.0 / getWidth();
        camY = scale / 2;
    }

    public static void main(String[] args) {
        new Bifurcation();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char ch = e.getKeyChar();
        if (ch == 'q') {
            moe /= 1.1;
            repaint();
        } else if (ch == 'e') {
            moe *= 1.1;
            repaint();
        }
    }

    @Override
    Color getColor(double x, double y) {
        if (x < 0 || y < 0 || y > 1 || x > 4) {
            return null;
        }
        double original_y = y;
        for (int i = 0; i < depth; ++i) {
            double new_y = x * y * (1 - y);
            if (Math.abs(new_y - original_y) < moe) {
                return Color.BLACK;
            }
            y = new_y;
        }
        return null;
    }
}
