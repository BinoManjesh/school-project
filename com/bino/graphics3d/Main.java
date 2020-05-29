package com.bino.graphics3d;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Comparator;

public class Main {

    private static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = SCREEN_WIDTH / 16 * 9;

    private Mesh mesh;
    private Camera camera;
    private Canvas canvas;
    private JFrame frame;

    public Main() {
        mesh = new Mesh("3d Objects/draw.obj");
        camera = new Camera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.z = 10;
        canvas = new Canvas();

        frame = new JFrame("3d graphics");

        Dimension size = new Dimension(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        frame.add(canvas);
        frame.pack();

        canvas.createBufferStrategy(3);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void start() {
        frame.setVisible(true);
        Thread thread = new Thread(this::run);
        thread.start();
    }

    public void run() {
        double timer = System.currentTimeMillis();
        int frames = 0;
        while (true) {
            

            update();
            render();
            

            frames++;
            if (System.currentTimeMillis() - timer >= 1000) {
                frame.setTitle("3d graphics | FPS: " + frames);
                timer += 1000;
                frames = 0;
            }
        }
    }

    private void update() {
        mesh.triangles.sort(Comparator.comparingInt(Triangle :: zSum));
    }

    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        for (Triangle triangle : mesh.triangles) {

            Vector2[] projected = new Vector2[3];
            for (int i = 0; i < 3; ++i) {
                projected[i] = camera.project(triangle.points[i]);
            }
            float intensity = (float) ((triangle.normal.z));
            if (intensity >= 0) {
                g.setColor(new Color(intensity, intensity, intensity));
                Renderer.fillTriangle(g, projected);
                // g.setColor(Color.RED);
                // Renderer.drawTriangle(g, projected);
            }
        }
            

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.start();
    }
}
