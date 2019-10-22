package art;

import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    
    private JFrame frame;
    
    Canvas() {
        setPreferredSize(new Dimension(512, 512));
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
        setPreferredSize(new Dimension(width, height));
        frame.pack();
    }
}
