import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

class FlappyBird extends JPanel {
    
    static final int WIDTH = 900;
    static final int HEIGHT = 600;
    
    private JFrame frame;
    private Bird bird;
    
    FlappyBird() {
        bird = new Bird();
        
        frame = new JFrame("Flappy Bird");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.addKeyListener(bird);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FlappyBird().start();
    }
    
    @Override
    public void paint(Graphics g) {
        bird.paint(g);
    }
    
    void update(float delta) {
        bird.update(delta);
    }
    
    void start() {
        long startTime = System.nanoTime();
        long endTime;
        while (true) {
            endTime = System.nanoTime();
            float delta = (endTime - startTime) * 1e-9f;
            update(delta);
            frame.repaint();
            startTime = endTime;
        }
    }
}
