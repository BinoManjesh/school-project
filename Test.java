import java.awt.*;
import javax.swing.*;

class Test extends JPanel {

    Test() {
        JFrame f = new JFrame();
        f.add(this);
        f.setSize(100,100);
        f.setVisible(true);
    }

    /*@Override
    public void paint(Graphics g) {
    g.fillRect(0, 0, 100, 100);
    }*/
   public void paint(Graphics g){
        g.drawString("fffd ", 0, 10);
    }
}
