package moving_ball;

import java.awt.*;

class Ball {
    
    private static final int BALL_SIZE = 100;
    
    private int x;
    private int y;
    
    Ball() {
        x = 0;
        y = 0;
    }
    
    void update(float delta) {
        
    }
    
    void render(Graphics g) {
        g.drawOval(x, y, BALL_SIZE, BALL_SIZE);
    }
}
