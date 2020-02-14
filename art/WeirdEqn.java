package art;

import java.awt.*;
import java.awt.event.KeyEvent;

class WeirdEqn extends Plot {

    private double moe = 0.1;

    private WeirdEqn() {
        scaleSpeed = 0.9;
    }

    public static void main(String[] args) {
        new WeirdEqn();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();
        if (ch == 'q') {
            moe *= 1.1;
            repaint();
        } else if (ch == 'e') {
            moe /= 1.1;
            repaint();
        }
    }

    @Override
    Color getColor(double x, double y) {
        double s1 = y - Math.cos(x - y);
        if (Math.abs(s1) < moe) {
            return Color.BLACK;
        } else {
            return null;
        }
    }
}
