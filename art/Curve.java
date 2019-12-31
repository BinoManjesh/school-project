package art;

import java.awt.*;

abstract class Curve extends Canvas {
    
    static int width = 1000, height = 640;
    double xScale = 1, yScale = 1;
    double originX = width / 2, originY = height / 2;
    double d = 1;
    
    Curve() {
        super(width, height);
    }
    
    abstract boolean isPoint(double x, double y);
    
    @Override
    public void paint(Graphics g) {
        g.drawLine(0, (int) originY, width, (int) originY);
        g.drawLine((int) originX, height, (int) originX, 0);
        double x = 0, y = 0;
        while (x <= width) {
            x += d;
            while (y <= height) {
                y += d;
                if (isPoint(originX - x, y - originY)) {
                    g.drawOval((int) (x), (int) (y), 1, 1);
                }
            }
            y = 0;
        }
    }
}