package snake;

import com.bino.game_lib.InputManager;
import com.bino.game_lib.Renderer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Snake extends InputManager {

    ArrayList<SnakePart> parts;
    private Direction direction;

    Snake() {
        init();
    }

    private void init() {
        parts = new ArrayList<>();

        parts.add(new SnakePart(0, 0));

        direction = Direction.RIGHT;
    }

    boolean update(float delta, Apple apple) {
        SnakePart firstPart = parts.get(0);
        int prevX = firstPart.x;
        int prevY = firstPart.y;
        if (firstPart.update(delta, direction)) {
            for (int i = 1; i < parts.size(); i++) {
                SnakePart part = parts.get(i);
                if (firstPart.x == part.x && firstPart.y == part.y) {
                    init();
                    return false;
                }
                int xc = part.x;
                part.x = prevX;
                prevX = xc;
                int yc = part.y;
                part.y = prevY;
                prevY = yc;
            }
            if (firstPart.x == apple.x && firstPart.y == apple.y) {
                parts.add(new SnakePart(prevX, prevY));
                return true;
            }
        }
        return false;
    }

    void draw(Renderer renderer) {
        for (SnakePart part : parts) {
            part.draw(renderer);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != Direction.LEFT) {
            direction = Direction.RIGHT;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && direction != Direction.RIGHT) {
            direction = Direction.LEFT;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && direction != Direction.UP) {
            direction = Direction.DOWN;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && direction != Direction.DOWN) {
            direction = Direction.UP;
        }
    }

    enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
}
