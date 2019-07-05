package secret.animation;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Dimension;

public abstract class Animation extends JPanel {
    
    private JFrame frame;
    protected boolean running;
    
    public Animation () {
        frame = new JFrame();
        
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setMaximumSize(new Dimension(200, 200));
        frame.setMinimumSize(new Dimension(200, 200));
        
        frame.setResizable(false);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocationRelativeTo(null);
        
        frame.add(this);
    }
    
    public void start () {
        frame.setVisible(true);
        running = true;
        float previousTime = System.nanoTime();
        while (running) {
            float currentTime = System.nanoTime();
            update((currentTime - previousTime) / 1e9f);
            previousTime = currentTime;
            repaint();
        }
    }
    
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        render(g);
    }
    
    abstract protected void update (float delta);
    
    abstract protected void render (Graphics g);
}
