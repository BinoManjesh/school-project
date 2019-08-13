import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Pong extends JPanel {

    private JFrame frame;
    private Bar b;

    private Pong() {
        frame = new JFrame("Pong");
        frame.add(this);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        b = new Bar(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, 0);
        frame.addKeyListener(b);
    }

    public static void main() {
        Pong p = new Pong();
        p.start();
    }

    private void start() {
        long startTime = System.nanoTime();
        long endTime;
        while (true) {
            endTime = System.nanoTime();
            float delta = (endTime - startTime) * 1e-9f;
            update(delta);
            startTime = endTime;
            frame.repaint();            
        }
    }

    private void update(float delta) {
        b.update(delta);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        b.paint(g);
    }
}
