package art;

import java.awt.Graphics;

abstract class Graph extends Canvas {
    
    static int width = 1000;
    static int height = 640;
    float xScale = 0.8f;
    float yScale = 100;
    float dt = 0.001f;
    
    Graph() {
        super(width, height);
    }
    
    abstract float getY(float x);
    
    @Override
    public void paint(Graphics g) {
        float origin = height / 2;
        float t = 0;
        g.drawLine(0, (int)origin, width, (int)origin);
        while (t <= width) {
            float y = origin + -yScale * getY(xScale*t);
            g.drawOval((int)(t), (int)(y), 1, 1);
            t += dt;
        }
    }
}
