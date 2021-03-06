package art;

import java.awt.*;
import java.awt.event.*;

class Pendulum extends Animation implements MouseListener, MouseMotionListener, KeyListener {

    private static final double SIZE_FRACTION = 0.1;

    private static final Color PRECISE = new Color(0, 0, 1, 0.5f);
    private static final Color APPROXIMATION = new Color(1, 0, 0, 0.5f);

    private double g = 10;
    private Bob bob1;
    private Bob bob2;
    private boolean dragging = false;

    private Pendulum() {
        bob1 = new Bob(PRECISE);
        bob2 = new Bob(APPROXIMATION);
        bob1.theta = Math.PI / 2;
        bob2.theta = Math.PI / 2;
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        frame.addKeyListener(this);
    }

    public static void main(String[] args) {
        System.out.println("Press Q to increase gravity and E to decrease gravity");
        System.out.println("Drag the mouse to reset the bobs");
        new Pendulum().start();
    }

    @Override
    void update(double dt) {
        if (!dragging) {
            bob1.omega -= g * Math.sin(bob1.theta) * dt;
            bob1.theta += bob1.omega * dt;

            bob2.omega -= g * bob2.theta * dt;
            bob2.theta += bob2.omega * dt;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth(), height = getHeight();
        double worldHeight;
        if (width > height) {
            worldHeight = height;
            Bob.centerX = width / 2.0;
            Bob.centerY = 0;
        } else {
            worldHeight = width / 2.0;
            Bob.centerX = width / 2.0;
            Bob.centerY = (height - worldHeight) / 2;
        }

        Bob.radius = worldHeight * (1 - SIZE_FRACTION);
        Bob.size = worldHeight * SIZE_FRACTION;

        bob1.draw(g);
        g.drawString("precise", 0, 10);
        bob2.draw(g);
        g.drawString("approximation", 0, 20);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragging = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragging = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        bob1.omega = 0;
        bob2.omega = 0;
        double theta = Math.atan((e.getX() - Bob.centerX) / (e.getY() - Bob.centerY));
        bob1.theta = theta;
        bob2.theta = theta;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int ch = e.getKeyChar();
        System.out.println("g: " + g);
        switch (ch) {
            case 'q':
                g /= 0.9;
                break;
            case 'e':
                g *= 0.9;
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
