package snake;

import com.bino.game_lib.Renderer;

import java.awt.*;

class SnakePart {

    static final float SIZE = 0.9f;
    private static final float SPEED = 10;
    private static final float TIME_PERIOD = 1 / SPEED;
    private static final Color COLOR = Color.BLACK;

    int x;
    int y;
    private float bigDelta;

    SnakePart(int x, int y) {
        this.x = x;
        this.y = y;
        bigDelta = 0;
    }

    boolean update(float delta, Snake.Direction direction) {
        bigDelta += delta;
        if (bigDelta > TIME_PERIOD) {
            bigDelta -= TIME_PERIOD;
            move(direction);
            if (x == Main.WORLD_SIZE) {
                x = 0;
            }
            if (x == -1) {
                x = Main.WORLD_SIZE;
            }
            if (y == Main.WORLD_SIZE) {
                y = 0;
            }
            if (y == -1) {
                y = Main.WORLD_SIZE;
            }
            return true;
        }
        return false;
    }

    private void move(Snake.Direction direction) {
        if (direction == Snake.Direction.RIGHT) {
            x += 1;
        }
        if (direction == Snake.Direction.LEFT) {
            x -= 1;
        }
        if (direction == Snake.Direction.DOWN) {
            y += 1;
        }
        if (direction == Snake.Direction.UP) {
            y -= 1;
        }
    }

    void draw(Renderer renderer) {
        renderer.setColor(COLOR);
        renderer.fillRect(x + (1 - SIZE) / 2, y + (1 - SIZE) / 2, SIZE, SIZE);
    }
}
