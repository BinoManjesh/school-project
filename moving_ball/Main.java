package moving_ball;

import com.bino.game_lib.ExtendViewport;
import com.bino.game_lib.Game;
import com.bino.game_lib.InputManager;
import com.bino.game_lib.Renderer;

import java.awt.*;

public class Main extends Game {

    static final Color TEXT_COLOR = Color.WHITE;
    private static final int SCREEN_SIZE = 1000;
    private static final Color BG_COLOR = Color.BLACK;

    private float fps;
    private Ball ball;
    private ExtendViewport viewport;
    private Renderer renderer;

    private Main() {
        super();

        this.setBackground(BG_COLOR);

        frame.setTitle("Moving Ball");
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(InputManager.getInstance());

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
    protected void update (float delta) {
        fps = 1 / delta;
        ball.update(delta);
    }

    @Override
    protected void draw(Graphics g) {
        renderer.setG(g);
        ball.draw(renderer);
        g.setColor(TEXT_COLOR);
        g.drawString("fps: " + fps, 0, 10);
    }

    @Override
    public void whenResized(int screenWidth, int screenHeight) {
        viewport.update(screenWidth, screenHeight);
    }
}
