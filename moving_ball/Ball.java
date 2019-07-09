package moving_ball;

import com.bino.game_lib.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;

class Ball {

    private static final int SIZE_CHANGE_RATE = 50;
    private static final float SPEED = 500;
    private static final Color COLOR = Color.RED;

    private float x;
    private float y;
    private float size;
    private InputManager manager;

    Ball() {
        x = 0;
        y = 0;
        size = 25;
        manager = InputManager.getInstance();
    }

    void update(float delta) {
        if (manager.getKeyPressed(KeyEvent.VK_RIGHT)) {
            x += SPEED * delta;
        }
        if (manager.getKeyPressed(KeyEvent.VK_LEFT)) {
            x -= SPEED * delta;
        }
        if (manager.getKeyPressed(KeyEvent.VK_DOWN)) {
            y += SPEED * delta;
        }
        if (manager.getKeyPressed(KeyEvent.VK_UP)) {
            y -= SPEED * delta;
        }
        if (manager.getKeyPressed(KeyEvent.VK_Q)) {
            size += SIZE_CHANGE_RATE * delta;
        }
        if (manager.getKeyPressed(KeyEvent.VK_E)) {
            size -= SIZE_CHANGE_RATE * delta;
        }
    }

    void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval((int) (x - size / 2), (int) (y - size / 2), (int) size, (int) size);
        g.setColor(Main.TEXT_COLOR);
        g.drawString("x: " + x, 0, 20);
        g.drawString("y: " + y, 0, 30);
        g.drawString("size: " + size, 0, 40);
    }
}
