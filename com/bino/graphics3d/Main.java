package com.bino.graphics3d;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Comparator;

public class Main extends JComponent {

    private static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = SCREEN_WIDTH / 16 * 9;
    
    Camera camera;

    private Mesh mesh;
    private JFrame frame;

    public Main() {
        super();

        mesh = new Mesh("3d Objects/draw.obj");
        camera = new Camera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.z = 10;

        frame = new JFrame("3d graphics");

        Dimension size = new Dimension(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        frame.add(this);
        frame.addKeyListener(new InputHandler(this));
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        update();
        render(g);
    }

    private void update() {
        mesh.triangles.sort(Comparator.comparingInt(Triangle :: zSum));
    }

    private void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        for (Triangle triangle : mesh.triangles) {

            Vector2[] projected = new Vector2[3];
            for (int i = 0; i < 3; ++i) {
                projected[i] = camera.project(triangle.points[i]);
            }
            float intensity = -(float) ((triangle.normal.dot(camera.front)));
            if (intensity >= 0) {
                g.setColor(new Color(intensity, intensity, intensity));
                Renderer.fillTriangle(g, projected);
                // g.setColor(Color.RED);
                // Renderer.drawTriangle(g, projected);
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
