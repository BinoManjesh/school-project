package art;

import java.awt.*;

abstract class Curve extends Canvas implements Zoomable {

    private static int width = 1000, height = 640;
    private double camX = 0, camY = 0;
    private double scale;

    Curve() {
        super(width, height);
    }

    abstract boolean isPoint(double x, double y);

    @Override
    public void paint(Graphics g) {
        g.drawLine(0, height / 2, width, height / 2);
        g.drawLine(width / 2, height, (int) originX, 0);
        int x, y = 0;
        while (y < height) {
            x = 0;
            while (x < width) {
                if (isPoint(originX - x, y - originY)) {
                    g.drawOval(x, y, 1, 1);
                }
            }
            y = 0;
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
}
