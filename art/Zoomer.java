package art;

import java.awt.Point;
import java.awt.event.*;

class Zoomer extends MouseAdapter {
    
    static final double speed = 0.05;
    MandelbrodSet obj;
    
    Zoomer(MandelbrodSet obj) {
        this.obj = obj;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        obj.camX = obj.camX + (x - obj.size / 2.0) * obj.scale;
        obj.camY = obj.camY + (obj.size / 2.0 - y) * obj.scale;
        obj.repaint();
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        obj.scale = (obj.scale * obj.size + speed * e.getPreciseWheelRotation()) / obj.size;
        obj.repaint();
    }
}
