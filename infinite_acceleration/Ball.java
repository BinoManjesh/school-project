package infinite_acceleration;

import java.awt.*;

class Ball {

    private static final float INIT_ANGULAR_VELOCITY = 0;
    private static final float ANGULAR_ACCELERATION = (float) (Math.PI / 2);
    private static final int MOVEMENT_RADIUS = 100;
    private static final int BALL_SIZE = 50;
    private static final float COLOR_CHANGE_RATE = 0.01f;

    private float angle;
    private float angularVelocity;
    private float red;

    Ball() {
        angle = 0;
        angularVelocity = INIT_ANGULAR_VELOCITY;
        red = 0;
    }

    void update(float delta) {
        angularVelocity += ANGULAR_ACCELERATION * delta;
        angle += angularVelocity * delta;
        red += COLOR_CHANGE_RATE * delta;
        if (red > 1) {
            red = 1;
        }
    }

    void render(Graphics g) {
        final int x = (int) (MOVEMENT_RADIUS + MOVEMENT_RADIUS * Math.sin(angle));
        final int y = (int) (MOVEMENT_RADIUS + MOVEMENT_RADIUS * Math.cos(angle));
        g.setColor(new Color(red, 0, 1 - red, 1));
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
        g.setColor(Color.BLACK);
        g.drawString("angular velocity(radians): " + angularVelocity, 0, 20);
        g.drawString("angular velocity(degrees): " + angularVelocity * 180 / Math.PI, 0, 30);
    }
}
