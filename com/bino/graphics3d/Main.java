package com.bino.graphics3d;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

class Main {

    private static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 500;

    public static void main(String[] args) {

        Mesh original = new Mesh("C:\\Users\\HOME\\Desktop\\something\\school-project\\com\\bino\\graphics3d\\cube" +
                ".obj");
        Mesh cube = original.copy();

        JComponent c = new JComponent() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                g.setColor(Color.WHITE);
                for (Triangle triangle : cube.triangles) {
                    Vector2[] projected = new Vector2[3];
                    double k = SCREEN_WIDTH / 2.0;
                    for (int i = 0; i < 3; ++i) {
                        projected[i] = project(k, triangle.points[i]);
                        projected[i].x = SCREEN_WIDTH / 2.0 + projected[i].x;
                        projected[i].y = SCREEN_HEIGHT / 2.0 - projected[i].y;
                    }
                    g.drawLine((int) projected[0].x, (int) projected[0].y, (int) projected[1].x, (int) projected[1].y);
                    g.drawLine((int) projected[1].x, (int) projected[1].y, (int) projected[2].x, (int) projected[2].y);
                    g.drawLine((int) projected[2].x, (int) projected[2].y, (int) projected[0].x, (int) projected[0].y);
                }
            }
        };
        c.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("3d graphics");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            frame.add(c);
            frame.pack();
            frame.setVisible(true);
        });

        long prevTime = System.nanoTime();
        double t1 = 0, t2 = 0;
        while (true) {
            long thisTime = System.nanoTime();
            double dt = (thisTime - prevTime) * 1e-9;
            prevTime = thisTime;

            t1 += Math.PI * dt;
            t2 += Math.PI * dt;

            for (int i = 0; i < cube.triangles.size(); ++i) {
                for (int j = 0; j < 3; ++j) {
                    cube.triangles.get(i).points[j] =
                            original.triangles.get(i).points[j].rotateX(t1).rotateZ(t2).add(0, 0, -4);
                }
            }

            c.repaint();
        }
    }

    static void fillTriangle(Vector2 p1, Vector2 p2, Vector2 p3) {
        Vector2[] p = new Vector2 {p1, p2, p3}
        Arrays.sort(p, new Comparator<Vector2>() {});

        int y = (int) highest.y;
    }

    static Vector2 project(double k, Vector3 p) {
        Vector2 projected = new Vector2();
        projected.x = -k * p.x / p.z;
        projected.y = -k * p.y / p.z;
        return projected;
    }
}