package snake;

import com.bino.game_lib.ExtendViewport;
import com.bino.game_lib.Game;
import com.bino.game_lib.Renderer;

import java.awt.*;

class Main extends Game {

    static final int WORLD_SIZE = 20;

    private ExtendViewport viewport;
    private Renderer renderer;

    private Snake snake;
    private Apple apple;

    private Main() {
        frame.setMaximumSize(new Dimension(640, 640));
        viewport = new ExtendViewport(WORLD_SIZE);
        renderer = new Renderer(viewport);
        this.setBackground(Color.GRAY);
        snake = new Snake();
        frame.addKeyListener(snake);
        apple = new Apple(10, 10);
    }

    public static void main(String[] args) {
        new Main().start();
    }

    @Override
    protected void update(float delta) {
        if (snake.update(delta, apple)) {
            apple = new Apple((int) (Math.random() * WORLD_SIZE), (int) (Math.random() * WORLD_SIZE));
        }
    }

    @Override
    protected void draw(Graphics g) {
        renderer.setG(g);
        apple.draw(renderer);
        snake.draw(renderer);
        g.drawString("score: " + snake.parts.size(), 0, 10);
    }

    @Override
    public void whenResized(int screenWidth, int screenHeight) {
        viewport.update(screenWidth, screenHeight);
    }
}
