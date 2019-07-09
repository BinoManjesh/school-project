package moving_ball;

import com.bino.game_lib.Game;

import java.awt.*;

public class Main extends Game {

    static final Color TEXT_COLOR = Color.BLACK;
    private static final int SCREEN_SIZE = 500;
    private static final Color BG_COLOR = Color.WHITE;

    private float fps;
    private Ball ball;

    private Main() {
        super();

        this.setBackground(BG_COLOR);

        frame.setTitle("Moving Ball");
        frame.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMaximumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMinimumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(InputManager.getInstance());

        fps = 0;

        ball = new Ball();
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
        ball.draw(g);
        g.setColor(TEXT_COLOR);
        g.drawString("fps: " + fps, 0, 10);
    }
}
