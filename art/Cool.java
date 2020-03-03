package art;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.*;

class Cool extends Plot {
    
    double moe = 0.1;

    @Override Color getColor(double x, double y) {
        if (abs(sin(y * sin(x))) < 10e-17) {
            return Color.BLACK;
        } else {
            return null;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        System.out.print(c);
        if (c == 'q') {
            moe *= 1.1;
        } else if (c == 'e') {
            moe /= 1.1;
        }
        repaint();
    }
}
