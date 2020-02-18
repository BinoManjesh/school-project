package art;

import java.awt.*;

class Pendulum extends Animation {

    private static final double G = 1;

    private static final double SIZE_FRACTION = 0.1;

    private static final Color PRECISE = new Color(0, 0, 1, 0.5f);
    private static final Color APPROXIMATION = new Color(1, 0, 0, 0.5f);

    private Bob bob1;
    private Bob bob2;

    private Pendulum() {
        bob1 = new Bob(PRECISE);
        bob2 = new Bob(APPROXIMATION);
        bob1.theta = Math.PI / 2;
        bob2.theta = Math.PI / 2;
    }

    public static void main(String[] args) {
        new Pendulum().start();
    }

    @Override
    void update(double dt) {
        bob1.omega -= G * Math.sin(bob1.theta) * dt;
        bob1.theta += bob1.omega * dt;

        bob2.omega -= G * bob2.theta * dt;
        bob2.theta += bob2.omega * dt;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth(), height = getHeight();
        double worldHeight;
        if (width > height) {
            worldHeight = height;
            Bob.centerX = width / 2.0;
            Bob.centerY = 0;
        } else {
            worldHeight = width / 2.0;
            Bob.centerX = width / 2.0;
            Bob.centerY = (height - worldHeight) / 2;
        }

        Bob.radius = worldHeight * (1 - SIZE_FRACTION);
        Bob.size = worldHeight * SIZE_FRACTION;

        bob1.draw(g);
        g.drawString("precise", 0, 10);
        bob2.draw(g);
        g.drawString("approximation", 0, 20);
    }
}
