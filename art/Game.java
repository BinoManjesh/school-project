package art;

import java.awt.*;

class Game extends Canvas {
    
    void start() {
        long startTime = System.nanoTime();
        while (true) {
            long thisTime = System.nanoTime();
            float delta = (thisTime - startTime) * 1e-9f;
            startTime = thisTime;
            update(delta);
            super.frame.repaint();
        }
    }
    
    void update(float delta) {}
    
    void draw (Graphics g) {}
    
    @Override
    public void paintComponent(Graphics g) {
        draw(g);
    }
}
