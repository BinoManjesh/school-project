package art;

import java.awt.*;

class Bob {
    Vector<Float> position;
    float angle;
    float velocity;
    float acceleration;
    float radius;
    static final float g = 9.8f;
    static final int size = 10;
    
    void update(float dt) {
        float acceleration = g*(float)Math.sin(angle)/radius;
        velocity += acceleration*dt;
        position.x += radius*(float)Math.cos(angle)*velocity*dt;
        position.y += radius*(float)Math.sin(angle)*velocity*dt;
    }
    
    void draw(Graphics g) {
        g.drawOval((int)(position.x-size/2), (int)(position.y-size/2), size, size);
    }
}
