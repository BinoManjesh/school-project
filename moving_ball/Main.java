package moving_ball;

import com.bino.game_lib.Game;
import java.awt.*;

public class Main extends Game {
    
    private static final int SCREEN_SIZE = 640;
    
    private float fps;
    private Ball ball;
    
    Main () {
        super();
        
        frame.setTitle("Input");
        frame.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMaximumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setMinimumSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        frame.setLocationRelativeTo(null);
        
        fps = 0;
        
        ball = new Ball();
    }
    
    @Override
    protected void update (float delta) {
        fps = 1 / delta;
        ball.update(delta);
    }
    
    @Override 
    protected void render (Graphics g) {
        ball.render(g);
        g.drawString("fps: " + fps, 0, 10);
    }
}
