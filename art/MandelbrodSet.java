package art;

import java.awt.*;

class MandelbrodSet extends Canvas {

    static final int size = 500, maxDivergence = 100;
    double scale = 4.0 / size;
    double camX = 0, camY = 0;
    
    MandelbrodSet() {
        super(size, size);
        super.frame.setResizable(false);
        Zoomer zoomer = new Zoomer(this);
        super.frame.addMouseListener(zoomer);
        super.frame.addMouseWheelListener(zoomer);
    }
    
    @Override
    public void paint(Graphics g) {
        int x = 0, y = 0;
        while (x <= size) {
            x++;
            while (y <= size) {
                y++;
                double x_ = (x  - size / 2.0) * scale + camX, y_ = (size / 2.0 - y) * scale + camY;
                Color color = getColor(x_, y_);
                g.setColor(color);
                g.drawOval(x, y, 1, 1);
            }
            y = 0;
        }
    }
    
    Color getColor(double x, double y) {
        int foo = (int) ((double)getDivergence(x, y) / maxDivergence * 16777215);
        int r = foo % 256;
        foo /= 256;
        int g = foo % 256;
        foo /= 256;
        int b = foo % 256;
        return new Color(r, g, b, 255);
    }
    
    int getDivergence(double x, double y) {
        return getDivergence(x, y, x, y, maxDivergence);
    }
    
    int getDivergence(double x, double y, double cx, double cy, int i) {
        if (i <= 0) {
            return 0;
        } else if (x*x + y*y > 4) {
            return i;
        } else {
            return getDivergence(x*x - y*y + cx, 2*x*y + cy, cx, cy, i - 1);
        }
    }
}
