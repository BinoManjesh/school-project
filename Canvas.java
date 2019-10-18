import java.awt.*;
import javax.swing.*;

class Canvas extends JPanel {
    
    private JFrame frame;
    
    Canvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame = new JFrame("Life");
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
