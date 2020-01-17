package art;

import javax.swing.*;
import java.awt.*;

abstract class Canvas extends JPanel {
    
    protected JFrame frame;
    
    Canvas() {
        setPreferredSize(new Dimension(512, 512));
        setMaximumSize(new Dimension(512, 512));
        setMinimumSize(new Dimension(512, 512));
        frame = new JFrame();
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    Canvas(int width, int height) {
        this();
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        frame.pack();
    }
}
