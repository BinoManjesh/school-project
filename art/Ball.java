package art;

import java.awt.*;

class Ball extends Animation {

    private double x = 10;
    private double radius = 20;
    private int vel = 1000;

    public static void main(String[] args) {
        new Ball().start();
    }

    @Override
    void update(double dt) {
        x += vel * dt;
        if (x + radius > getWidth()) {
            vel = -vel;
            x = getWidth() - radius;
        }
        if (x - radius < 0) {
            vel = -vel;
            x = radius;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double y = 50;
        g.fillOval((int) (x - radius), (int) (y - radius), (int) radius * 2, (int) radius * 2);
    }
}
