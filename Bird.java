import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

class Bird extends KeyAdapter {
    private static final int SIZE = 50;
    private static final float G = 500;
    private static final float JUMP_VEL = 250;

    private final float x;
    private float y;
    private float velY;
    private boolean shouldJump;

    Bird() {
        x = 0;
        y = 0;
        velY = 0;
        shouldJump = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        if(keycode == KeyEvent.VK_UP) {
            if (shouldJump) { 
                velY -= JUMP_VEL;
                shouldJump = false;
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();

        if(keycode == KeyEvent.VK_UP) {
            shouldJump = true;
        }
    }

    void update(float delta) {
        velY += G * delta;
        y += velY * delta;
        
        if (y > FlappyBird.HEIGHT - SIZE) {
            y = FlappyBird.HEIGHT - SIZE;
            velY = 0;
        } else if (y < 0) {
            y = 0;
            velY = 0;
        }
    }

    void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval((int) x, (int) y, SIZE, SIZE);
    }
}
