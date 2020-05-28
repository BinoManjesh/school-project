package com.bino.graphics3d;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Arrays;
import java.util.Comparator;

class Main {

    private static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = SCREEN_WIDTH / 16 * 9;

    public static void main(String[] args) throws InterruptedException {

        Mesh original = new Mesh("3d Objects/draw.obj");
        Mesh cube = original.copy();

        JFrame frame = new JFrame("3d graphics");
        Dimension size = new Dimension(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Canvas canvas = new Canvas();
        frame.add(canvas);
        frame.pack();
        canvas.createBufferStrategy(3);
        frame.setVisible(true);

        long prevTime = System.nanoTime();
        double t1 = 0, t2 = 0, t3 = 0;
        double timer = 0;
        int frames = 0;
        while (true) {
            long thisTime = System.nanoTime();
            double dt = (thisTime - prevTime) * 1e-9;
            prevTime = thisTime;

            timer += dt;
            t1 += Math.PI * dt;
            t2 += 0.25 * Math.PI * dt;
            t3 += 0.125 * Math.PI * dt;

            for (int i = 0; i < cube.triangles.size(); ++i) {
                for (int j = 0; j < 3; ++j) {
                    cube.triangles.get(i).points[j] =
                            original.triangles.get(i).points[j].rotateX(t1).rotateY(t2).rotateZ(t3).add(0, 0, -6);
                    cube.triangles.get(i).normal = original.triangles.get(i).normal.rotateX(t1).rotateZ(t2);
                }
            }
            cube.triangles.sort(Comparator.comparingInt(Triangle :: zSum));
            BufferStrategy bs = canvas.getBufferStrategy();
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

            for (Triangle triangle : cube.triangles) {
                Vector2[] projected = new Vector2[3];
                double k = SCREEN_WIDTH / 2.0;
                for (int i = 0; i < 3; ++i) {
                    projected[i] = project(k, triangle.points[i]);
                    projected[i].x = SCREEN_WIDTH / 2.0 + projected[i].x;
                    projected[i].y = SCREEN_HEIGHT / 2.0 - projected[i].y;
                }
                float intensity = (float) ((triangle.normal.z + 1) / 2.0);
                g.setColor(new Color(intensity, intensity, intensity));
                fillTriangle(g, projected);
                // g.setColor(Color.RED);
                // drawTriangle(g, projected);
            }

            g.dispose();
            bs.show();
            frames++;
            if (timer >= 1) {
                frame.setTitle("3d graphics | FPS: " + frames);
                timer = 0;
                frames = 0;
            }
        }
    }

    static void fillTriangle(Graphics g, Vector2[] p) {
        Arrays.sort(p, (a, b) -> (int) (a.y - b.y));
        if (p[0].y == p[1].y) {
            fillDownTriangle(g, p);
        } else if (p[1].y == p[2].y) {
            fillUpTriangle(g, p);
        } else {
            Vector2 p3 = new Vector2();
            p3.y = p[1].y;
            p3.x = p[0].x + (p3.y - p[0].y) * (p[0].x - p[2].x) / (p[0].y - p[2].y);
            fillUpTriangle(g, p[0], p[1], p3);
            fillDownTriangle(g, p3, p[1], p[2]);
        }
    }

    static void fillUpTriangle(Graphics g, Vector2... p) {
        int y = (int) Math.round(p[0].y);
        double x1 = p[0].x, x2 = p[0].x;
        double dx1 = (p[1].x - p[0].x) / (p[1].y - p[0].y);
        double dx2 = (p[2].x - p[0].x) / (p[2].y - p[0].y);
        while (y + 0.5 <= p[2].y) {
            g.drawLine((int) Math.round(x1), y, (int) Math.round(x2), y);
            x1 += dx1;
            x2 += dx2;
            y++;
        }
    }

    static void fillDownTriangle(Graphics g, Vector2... p) {
        int y = (int) Math.round(p[0].y);
        double x0 = p[0].x, x1 = p[1].x;
        double dx0 = (p[2].x - p[0].x) / (p[2].y - p[0].y);
        double dx1 = (p[2].x - p[1].x) / (p[2].y - p[1].y);
        while (y + 0.5 <= p[2].y) {
            g.drawLine((int) Math.round(x0), y, (int) Math.round(x1), y);
            x0 += dx0;
            x1 += dx1;
            y++;
        }
    }

    static void drawTriangle(Graphics g, Vector2[] p) {
        for (int i = 0; i < 3; ++i) {
            int j = (i + 1) % 3;
            g.drawLine((int) p[i].x, (int) p[i].y, (int) p[j].x, (int) p[j].y);
        }
    }

    static Vector2 project(double k, Vector3 p) {
        Vector2 projected = new Vector2();
        projected.x = -k * p.x / p.z;
        projected.y = -k * p.y / p.z;
        return projected;
    }
}