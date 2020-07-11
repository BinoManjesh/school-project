package art;

import java.awt.*;
import java.awt.event.*;

class ChaosEquations extends Canvas {

    private static final int WIDTH = 1000, HEIGHT = WIDTH*9/16;
    private static final int N_POINTS = 100000;
    private final Color[] colors;
    long prevTime;
    boolean pause;
    private double scale = 0.0005;
    private double camX, camY;
    private double speed = 0.01;
    private double t;

    ChaosEquations() {
        super(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        frame.setTitle("Chaos Equations");

        MouseInput mouseInput = new MouseInput();
        frame.addMouseWheelListener(mouseInput);
        frame.addMouseMotionListener(mouseInput);
        frame.addMouseListener(mouseInput);
        frame.addKeyListener(new KeyInput());

        colors = new Color[N_POINTS];
        for (int i = 0; i < N_POINTS; ++i) {
            colors[i] = new Color((int) (Math.random()*0xFFFFFF));
        }
        prevTime = System.nanoTime();
    }

    public static void main(String[] args) {
        ChaosEquations obj = new ChaosEquations();
        while (true) {
            obj.repaint();
        }
    }

    double getNewX(double x, double y, double t) {
        return -t*t - x*y + t;
    }

    double getNewY(double x, double y, double t) {
        return -x*y + x*t + y + t;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long thisTime = System.nanoTime();
        if (!pause)
            t += (thisTime - prevTime)*1e-9*speed;
        prevTime = thisTime;
        double x = t, y = t;
        for (int i = 0; i < N_POINTS; ++i) {
            g.setColor(colors[i]);
            g.fillRect(getX(x), getY(y), 1, 1);
            double newX = getNewX(x, y, t);
            double newY = getNewY(x, y, t);
            if (Double.isNaN(newX) || Double.isNaN(newY))
                break;
            x = newX;
            y = newY;
        }
        g.setColor(Color.WHITE);
        g.drawString("t:  " + t, 0, 10);
        g.drawString("speed:  " + speed, 0, 22);
    }

    int getX(double x) {
        return (int) (camX + getWidth()/2 + x/scale);
    }

    int getY(double y) {
        return (int) (camY + getHeight()/2 - y/scale);
    }

    class MouseInput extends MouseAdapter {

        private int prevX, prevY;

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            scale *= Math.pow(1.5, e.getPreciseWheelRotation());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            prevX = e.getX();
            prevY = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            camX += e.getX() - prevX;
            camY += e.getY() - prevY;
            prevX = e.getX();
            prevY = e.getY();
        }
    }

    class KeyInput extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'q':
                    speed *= 1.1;
                    break;
                case 'e':
                    speed /= 1.1;
                    break;
                case 'w':
                    speed = -speed;
                    break;
                case ' ':
                    pause = !pause;
            }
        }
    }
}
