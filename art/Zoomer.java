package art;

import java.awt.Point;
import java.awt.event.*;

class Zoomer extends MouseAdapter {
    
    static final double speed = 0.9;
    MandelbrotSet obj;
    
    Zoomer(MandelbrotSet obj) {
        this.obj = obj;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() - 8, y = e.getY() - 31;
        obj.camX = obj.camX + (x - obj.size / 2.0) * obj.scale;
        obj.camY = obj.camY + (obj.size / 2.0 - y) * obj.scale;
        System.out.println(x + " " + y);
        obj.repaint();
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int scroll = e.getWheelRotation();
        if (scroll > 0) {
            obj.scale *= speed;
        } else {
            obj.scale /= speed;
        }
        obj.repaint();
    }
}
