import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Pong extends JPanel {

    private JFrame frame;
    
    private Pong() {
        frame = new JFrame("Pong");
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    
    public static void main() {
        Pong p = new Pong();
        p.start();
    }
    
    private void start() {
        long startTime = System.nanoTime()
        while (true) {
            frame.repaint();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        
    }
}
