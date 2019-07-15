package infinite_acceleration;

import com.bino.game_lib.ExtendViewport;
import com.bino.game_lib.Game;
import com.bino.game_lib.Renderer;

import java.awt.*;

class Main extends Game {

    private static final int SCREEN_SIZE = 300;

    private float fps;
    private Ball ball;
    private ExtendViewport viewport;
    private Renderer renderer;

    private Main() {
        super();

        frame.setTitle("Infinite Acceleration");
        frame.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMaximumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMinimumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setLocationRelativeTo(null);

        fps = 0;
        ball = new Ball();

        viewport = new ExtendViewport(SCREEN_SIZE, SCREEN_SIZE);
        renderer = new Renderer(viewport);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    @Override
    protected void update(float delta) {
        fps = 1 / delta;
        ball.update(delta);
    }

    @Override
    protected void draw(Graphics g) {
        renderer.setG(g);
        ball.draw(renderer);
        g.drawString("fps: " + fps, 0, 10);
    }

    @Override
    public void whenResized(int screenWidth, int screenHeight) {
        viewport.update(screenWidth, screenHeight);
    }
}
