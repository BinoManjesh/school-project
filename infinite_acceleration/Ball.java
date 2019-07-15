package infinite_acceleration;

import com.bino.game_lib.Renderer;

import java.awt.*;

class Ball {

    private static final float INIT_RPS = 0;
    private static final float RPS_INCREASE_RATE = 0.25f;
    private static final int MOVEMENT_RADIUS = 100;
    private static final int BALL_SIZE = 50;
    private static final float COLOR_CHANGE_RATE = 0.01f;

    private float angle;
    private float rps;
    private float red;

    Ball() {
        angle = 0;
        rps = INIT_RPS;
        red = COLOR_CHANGE_RATE * INIT_RPS / RPS_INCREASE_RATE;
    }

    void update(float delta) {
        rps += RPS_INCREASE_RATE * delta;
        angle += rps * Math.PI * 2 * delta;
        red += COLOR_CHANGE_RATE * delta;
        if (red > 1) {
            red = 1;
        }
    }

    void draw(Renderer renderer) {
        final int x = (int) (MOVEMENT_RADIUS + MOVEMENT_RADIUS * Math.sin(angle));
        final int y = (int) (MOVEMENT_RADIUS + MOVEMENT_RADIUS * Math.cos(angle));
        renderer.setColor(new Color(red, 0, 1 - red, 1));
        renderer.fillOval(x, y, BALL_SIZE, BALL_SIZE);
        renderer.setColor(Color.BLACK);
    }
}
