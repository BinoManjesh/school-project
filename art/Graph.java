package art;

import java.awt.*;

abstract public class Graph extends Canvas {
    float xScale = 1;
    float yScale = 1;
    private float dt = 0.001f;
    
    abstract double getY(double x);
    
    @Override
    public void paintComponent(Graphics g) {
        int width = getWidth(), height = getHeight();
        float origin = height / 2f;
        float t = 0;
        g.drawLine(0, (int)origin, width, (int)origin);
        while (t <= width) {
            float y = (float) (origin + -yScale * getY(xScale*t));
            g.drawOval((int)(t), (int)(y), 1, 1);
            t += dt;
        }
    }
}
