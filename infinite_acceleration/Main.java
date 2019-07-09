package infinite_acceleration;

import com.bino.game_lib.Game;

import java.awt.*;

class Main extends Game {

    private static final int SCREEN_SIZE = 300;

    private float fps;
    private Ball ball;

    private Main() {
        super();

        frame.setTitle("Infinite Acceleration");
        frame.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMaximumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMinimumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setLocationRelativeTo(null);

        fps = 0;
        ball = new Ball();
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
        ball.draw(g);
        g.drawString("fps: " + fps, 0, 10);
    }
}
