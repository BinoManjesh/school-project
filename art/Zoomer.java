package art;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Zoomer extends MouseAdapter {

    private static final double speed = 0.9;
    private static int minX, minY;
    private MandelbrotSet obj;
    private File config;
    
    Zoomer(MandelbrotSet obj) {
        this.obj = obj;
        config = new File("zoomer.config");
        if (!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner scanner = new Scanner(config);
            minX = scanner.nextInt();
            minY = scanner.nextInt();
        } catch (Exception e) {
            minX = 0;
            minY = 0;
            e.printStackTrace();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() - minX, y = e.getY() - minY;
        obj.camX = obj.camX + (x - MandelbrotSet.size / 2.0) * obj.scale;
        obj.camY = obj.camY + (MandelbrotSet.size / 2.0 - y) * obj.scale;
        System.out.println(obj.camX + " " + obj.camY);
        obj.repaint();
        boolean shouldSave = false;
        if (x < minX) {
            minX = x;
            shouldSave = true;
        }
        if (y < minY) {
            minY = y;
            shouldSave = true;
        }
        if (shouldSave) {
            try {
                PrintWriter writer = new PrintWriter(config);
                writer.println(minX + " " + minY);
                writer.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
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
