package art;

import java.awt.*;

class ChaosEquations extends Canvas {

    private static final int WIDTH = 1000, HEIGHT = WIDTH*9/16;
    private static final int N_POINTS = 100000;
    private static final double SCALE = 100;

    final long startTime;
    private final Color[] colors;

    ChaosEquations() {
        super(WIDTH, HEIGHT);
        colors = new Color[N_POINTS];
        for (int i = 0; i < N_POINTS; ++i) {
            colors[i] = new Color((int) (Math.random()*0xFFFFFF));
        }
        startTime = System.nanoTime();
    }

    public static void main(String[] args) throws InterruptedException {
        ChaosEquations obj = new ChaosEquations();
        while (true) {
            obj.repaint();
            Thread.sleep(500);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        double t = (System.nanoTime() - startTime)*1e-9;
        double x = t, y = t;
        for (int i = 0; i < N_POINTS; ++i) {
            g.setColor(colors[i]);
            g.fillRect(getX(x), getY(y), 4, 4);
            double newX = getNewX(x, y, t);
            double newY = getNewY(x, y, t);
            //            g.drawLine(getX(x), getY(y), getX(newX), getY(newY));
            x = newX;
            y = newY;
            if (Double.isNaN(x) || Double.isNaN(y)) {
                System.out.println("WHHHHHHHHHHHHHHHHHHHHHHHYYYYYYYYYYY");
            }
        }
    }

    int getX(double x) {
        return (int) (WIDTH/2 + x/SCALE);
    }

    int getY(double y) {
        return (int) (HEIGHT/2 - y/SCALE);
    }

    double getNewX(double x, double y, double t) {
        return x*x - x*t + y + t;
    }

    double getNewY(double x, double y, double t) {
        return x*x + y*y + t*t - x*t - x - y;
    }
}
