package art;

import java.awt.*;

class Bob {

    static double centerX, centerY;
    static double radius;
    static double size;
    double theta;
    double omega;
    private Color color;

    Bob(Color color) {
        this.color = color;
        theta = 0;
        omega = 0;
    }

    void draw(Graphics g) {
        g.setColor(color);
        double x = centerX + radius * Math.sin(theta);
        double y = centerY + radius * Math.cos(theta);
        g.fillOval((int) (x - size), (int) (y - size), 2 * (int) size, 2 * (int) size);
        g.drawLine((int) centerX, (int) centerY, (int) x, (int) y);
    }
}
