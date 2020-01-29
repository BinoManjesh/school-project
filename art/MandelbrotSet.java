package art;

import java.awt.*;

class MandelbrotSet extends Canvas implements Zoomable {

    private static final int size = 250;
    private static final int maxDivergence = 1000;
    private double scale = 4.0 / size;
    private double camX = -1.7490812690237831, camY = -4.9135633356879E-6;

    //-1.9825307442357645 1.1269861165180146E-16
    //-1.9854737218475564 -1.92962847813101E-5
    //-1.9854736614426023 -1.9321688831440083E-5
    //-0.8119294087512888 0.17181641810440956
    //-1.7490812690237831 -4.9135633356879E-6
    //-1.40881256903367 -0.1327512339998311
    //-0.7264926148300772 -0.25148380542817095

    MandelbrotSet() {
        super(size, size);
        super.frame.setResizable(false);
        Zoomer zoomer = new Zoomer(this);
        super.frame.addMouseListener(zoomer);
        super.frame.addMouseWheelListener(zoomer);
    }

    public static void main(String[] args) {
        new MandelbrotSet();
    }

    @Override
    public void paint(Graphics g) {
        int x, y = 0;
        while (y < size) {
            x = 0;
            while (x < size) {
                double x_ = camX + (x  - size / 2.0) * scale, y_ = camY + (size / 2.0 - y) * scale;
                Color color = getColor(x_, y_);
                g.setColor(color);
                g.drawOval(x, y, 1, 1);
                x++;
            }
            y++;
        }
        g.setColor(Color.BLACK);
        g.drawString((scale * size) + "", 0, 10);
        g.setColor(Color.RED);
        final int radius = 5;
        g.drawOval((int)(size/2.0 - radius), (int)(size/2.0 - radius), radius * 2, radius * 2);
    }

    private Color getColor(double x, double y) {
        int foo = (int) ((double)getDivergence(x, y) / maxDivergence * 16777215);
        int r = foo % 256;
        foo /= 256;
        int g = foo % 256;
        foo /= 256;
        int b = foo % 256;
        return new Color(r, g, b, 255);
    }

    private int getDivergence(double x, double y) {
        return getDivergence(x, y, x, y, maxDivergence);
    }

    private int getDivergence(double x, double y, double cx, double cy, int i) {
        if (i <= 0) {
            return 0;
        } else if (x*x + y*y > 4) {
            return i;
        } else {
            return getDivergence(x*x - y*y + cx, 2*x*y + cy, cx, cy, i - 1);
        }
    }

    @Override
    public void setCam(double camX, double camY) {
        this.camX = camX;
        this.camY = camY;
    }

    @Override
    public double getCamX() {
        return camX;
    }

    @Override
    public double getCamY() {
        return camY;
    }

    @Override
    public double getScale() {
        return scale;
    }

    @Override
    public void setScale(double scale) {
        this.scale = scale;
    }

    @Override
    public int getWidth() {
        return size;
    }

    @Override
    public int getHeight() {
        return size;
    }
}
