package art;

import java.awt.*;

class Bob {
    Vector<Float> start;
    Vector<Float> position;
    float angle;
    float velocity;
    float radius;
    static final float g = 1000;
    static final int size = 10;
    
    Bob(Vector<Float> start, Vector<Float> position) {
        this.position = position;
        this.start = start;
        Vector<Float> diff = new Vector<Float>(position.x-start.x, position.y-start.y);
        angle = (float)Math.atan(diff.x/diff.y);
        radius = (float)Math.sqrt((float)Math.pow(diff.x, 2) + (float)Math.pow(diff.y, 2));
        velocity = 0;
    }
    
    void update(float dt) {
        float acceleration = -g*(float)Math.sin(angle)/radius;
        velocity += acceleration*dt;
        angle+=velocity*dt;
        position.x += radius*(float)Math.cos(angle)*velocity*dt;
        position.y -= radius*(float)Math.sin(angle)*velocity*dt;
    }
    
    void draw(Graphics g) {
        g.fillOval((int)(position.x-size/2), (int)(position.y-size/2), size, size);
        g.drawLine((int)(start.x+0), (int)(start.y+0),
        (int)(position.x+0), (int)(position.y+0));
    }
}
