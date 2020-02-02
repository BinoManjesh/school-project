package art;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

class Stripes extends Plot {

    private float i = 0, j = 0;

    public static void main(String[] args) {
        new Stripes();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scale = 2 * Math.PI / Math.min(getWidth(), getHeight());
        System.out.println(i + " " + j);
    }

    @Override
    Color getColor(double x, double y) {
        double function = 0.5 * Math.cos(i * x) + 0.5 * Math.cos(j * y);
        int c = (int) (255 * (function + 1) / 2);
        return new Color(c, c, c);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();
        switch (ch) {
            case 'q':
                i++;
                repaint();
                break;
            case 'e':
                i--;
                repaint();
                break;
            case 'a':
                j++;
                repaint();
                break;
            case 'd':
                j--;
                repaint();
                break;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
