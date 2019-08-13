import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Ball extends KeyAdapter {
    
    float x;
    float y;
    float velX;
    float velY;
    float accX;
    float accY;
    float drag = 0.000000000000001f;
    Color color;
    
    int up;
    int left;
    int down;
    int right;
    
    
    Ball(int up, int left, int down, int right, int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.color = color;
    }
    
    void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, 50, 50);
    }
    
    void update(float delta) {
        velX += accX * delta;
        velY += accY * delta;
        velX -= velX * drag * delta;
        velY -= velY * drag * delta;
        x += velX * delta;
        y += velY * delta;
        if (x > 500) {
            x = 500;
            velX = -velX;
        } else if(x < 0) {
            x = 0;
            velX = -velX;
        }
        if (y > 500) {
            y = 500;
            velY = -velY;
        } else if(y < 0) {
            y = 0;
            velY = -velY;
        }
    }
    
    void collide(Ball ball) {
        float sqrDist = (float) (Math.pow(ball.x - x, 2) + Math.pow(ball.y - y, 2));
        if (sqrDist < 625) {
            float temp = ball.velX;
            ball.velX = velX;
            velX = temp;
            temp = ball.velY;
            ball.velY = velY;
            velY = temp;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == right) {
            accX = 0.0000000001f;
        }
        if (keycode == left) {
            accX = -0.0000000001f;
        }
        if (keycode == down) {
            accY = 0.0000000001f;
        }
        if (keycode == up) {
            accY = -0.0000000001f;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == right || keycode == left) {
            accX = 0;
        }
        if (keycode == up || keycode == down) {
            accY = 0;
        }
    }
}