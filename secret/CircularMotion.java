package secret;

import secret.animation.Animation;

import java.awt.Graphics;
import java.awt.Color;

class CircularMotion extends Animation {
    
    private static final float ANGULAR_VELOCITY = 360;
    
    private float angle;
    private int x;
    private int y;
    private float fps;
    
    @Override
    protected void update (float delta) {
        angle += delta * ANGULAR_VELOCITY;
        x = (int)(100 + 75 * Math.sin(angle * Math.PI / 180)) - 25;
        y = (int)(100 + 75 * Math.cos(angle * Math.PI / 180)) - 25;        
        fps = 1 / delta;
    }
    
    @Override
    protected void render (Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
        g.drawString("Framerate: " + fps, 100, 100);
    }
    
    public static void main (String[] args) {
        new CircularMotion().start();
    }
}
