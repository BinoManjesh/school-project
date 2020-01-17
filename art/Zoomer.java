package art;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

class Zoomer extends MouseAdapter {

    private static final double speed = 0.9;
    private Zoomable obj;

    Zoomer(Zoomable obj) {
        this.obj = obj;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() - 8, y = e.getY() - 31;
        double camX = obj.getCamX() + (x - obj.getWidth() / 2.0) * obj.getScale();
        double camY = obj.getCamY() + (obj.getHeight() / 2.0 - y) * obj.getScale();
        obj.setCam(camX, camY);
        System.out.println(obj.getCamX() + " " + obj.getCamX());
        obj.repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int scroll = e.getWheelRotation();
        if (scroll > 0) {
            obj.setScale(obj.getScale() * speed);
        } else {
            obj.setScale(obj.getScale() / speed);
        }
        obj.repaint();
    }
}
