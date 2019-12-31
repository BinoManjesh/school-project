package art;

import java.awt.*;

class MandelbrodSet extends Canvas {

    static final int width = 1000, height = 640, maxDivergence = 100;
    int originX = width / 2, originY = height / 2;
    
    MandelbrodSet() {
        super(width, height);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawLine(0, (int) originY, width, (int) originY);
        g.drawLine((int) originX, height, (int) originX, 0);
        int x = 0, y = 0;
        while (x <= width) {
            x++;
            while (y <= height) {
                y++;
                Color color = getColor(originX - x, y - originY);
                g.setColor(color);
                g.fillOval(x, y, 1, 1);
            }
            y = 0;
        }
    }
    
    Color getColor(int x, int y) {
        int foo = getDivergence(x, y) / maxDivergence * 16777216;
        int r = foo % 
    }
    
    int getDivergence(int x, int y) {
        return getDivergence(x, y, maxDivergence + 1);
    }
    
    int getDivergence(int x, int y, int i) {
        if (i >= maxDivergence) {
            return 0;
        } else if (x*x + y*y > 4) {
            return i;
        } else {
            return getDivergence(x, y, i - 1);
        }
    }
}
