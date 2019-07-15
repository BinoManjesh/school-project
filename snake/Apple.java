package snake;

import com.bino.game_lib.Renderer;

import java.awt.*;

class Apple {

    int x;
    int y;

    Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Renderer renderer) {
        renderer.setColor(Color.RED);
        renderer.fillRect(x + (1 - SnakePart.SIZE) / 2, y + (1 - SnakePart.SIZE) / 2, SnakePart.SIZE, SnakePart.SIZE);
    }
}
