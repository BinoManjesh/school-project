package art;

import java.awt.*;

abstract class Curve extends Canvas implements Zoomable {

    private static int width = 250, height = 250;
    private double camX = 0, camY = 0;
    private double scale = 1;

    Curve() {
        super(width, height);
        Zoomer zoomer = new Zoomer(this);
        super.frame.addMouseListener(zoomer);
        super.frame.addMouseWheelListener(zoomer);
    }

    abstract boolean isPoint(double x, double y);

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Started");
        g.setColor(Color.BLACK);
        int x, y = 0;
        while (y < height) {
            x = 0;
            while (x < width) {
                double x_ = camX + (x  - width / 2.0) * scale, y_ = camY + (height / 2.0 - y) * scale;
                if (isPoint(x_, y_)) {
                    g.drawOval(x, y, 1, 1);
                }
                x++;
            }
            y++;
        }
        System.out.println("Painted");
        g.drawLine(0, 0, width, height);
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
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
