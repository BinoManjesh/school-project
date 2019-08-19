import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Life extends JPanel {
    
    private JFrame frame;
    
    private static final int TILE_SIZE = 10;
    private static final int WIDTH = 150;
    private static final int HEIGHT = 50;
    
    Life() {
        frame = new JFrame("Life");
        this.setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main (String[] args) {
        new Life();
    }
}