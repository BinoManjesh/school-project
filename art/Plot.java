package art;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

abstract class Plot extends Canvas {

    protected double camX = 0, camY = 0, scale = 1;

    Plot() {
        init();
    }

    Plot(int width, int height) {
        super(width, height);
        init();
    }

    abstract Color getColor(double x, double y);

    private void init() {
        MouseInput min = new MouseInput();
        super.frame.addMouseListener(min);
        super.frame.addMouseMotionListener(min);
        super.frame.addMouseWheelListener(min);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth(), height = getHeight();
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                double _x = camX + (x - width / 2.0) * scale;
                double _y = camY + (height / 2.0 - y) * scale;
                Color color = getColor(_x, _y);
                if (color != null) {
                    g.setColor(color);
                    g.drawOval(x, y, 1, 1);
                }
            }
        }
        g.setColor(Color.RED);
        int radius = 2;
        g.drawOval(width / 2 - radius, height / 2 - radius, radius * 2, radius * 2);
    }

    class MouseInput extends MouseAdapter {

        private static final double speed = 0.9;

        double prevX, prevY;

        @Override
        public void mousePressed(MouseEvent e) {
            prevX = e.getX();
            prevY = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            double currentX = e.getX(), currentY = e.getY();
            double deltaX = currentX - prevX;
            double deltaY = prevY - currentY;
            camX -= deltaX * scale;
            camY -= deltaY * scale;
            prevX = currentX;
            prevY = currentY;
            repaint();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            int scroll = e.getWheelRotation();
            if (scroll > 0) {
                scale *= speed;
            } else {
                scale /= speed;
            }
            repaint();
        }
    }
}
