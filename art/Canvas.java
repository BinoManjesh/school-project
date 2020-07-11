package art;

import javax.swing.*;
import java.awt.*;

abstract class Canvas extends JPanel {

    protected JFrame frame;

    Canvas(int width, int height) {
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        frame = new JFrame();
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    Canvas() {
        this(512, 512);
    }
}
