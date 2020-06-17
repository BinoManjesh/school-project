package com.bino.graphics3d.test.camera;

import com.bino.graphics3d.Camera;
import com.bino.graphics3d.math.Vector;
import com.bino.graphics3d.util.KeyHandler;
import com.bino.graphics3d.util.MeshLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = SCREEN_WIDTH / 16 * 9;

    private final Vector[] vertices;
    private final Integer[] indices;
    private final Integer[] order;
    private final KeyHandler handler;
    private final Camera camera;
    private final Canvas canvas;
    private int fps;

    private Main() {
        ArrayList<Vector> verticesList = new ArrayList<>();
        ArrayList<Integer> indicesList = new ArrayList<>();
        MeshLoader.load("3d objects/teapot.obj", verticesList, indicesList);
        vertices = new Vector[verticesList.size()];
        indices = new Integer[indicesList.size()];
        verticesList.toArray(vertices);
        indicesList.toArray(indices);
        order = new Integer[indices.length / 3];
        handler = new KeyHandler();
        for (int i = 0; i < indices.length / 3; i++) {
            order[i] = i * 3;
        }
        camera = new Camera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.z = -10;
        camera.update();
        canvas = new Canvas();

        JFrame frame = new JFrame("Camera Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);
        canvas.addMouseMotionListener(camera);

        frame.add(canvas);
        frame.addKeyListener(handler);
        frame.pack();
        canvas.createBufferStrategy(3);

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        frame.getContentPane().setCursor(blankCursor);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        long lastTime = System.nanoTime();
        float timer = 0;
        int frames = 0;
        while (true) {
            long thisTime = System.nanoTime();
            float dt = (thisTime - lastTime) * 1e-9f;
            lastTime = thisTime;
            timer += dt;
            update(dt);
            render();
            frames++;
            if (timer >= 1) {
                fps = frames;
                frames = 0;
                timer = 0;
            }
        }
    }

    private int compare(int b, int a) {
        float zA = 0, zB = 0;
        for (int i = 0; i < 3; ++i) {
            zA += camera.project(vertices[indices[a + i]]).z;
            zB += camera.project(vertices[indices[b + i]]).z;
        }
        return Float.compare(zA, zB);
    }

    private void update(float dt) {
        final float speed = 10, angularSpeed = 2 * (float)Math.PI / 3;
        if (handler.isKeyPressed(KeyEvent.VK_SPACE)) {
            camera.position.y -= speed * dt;
        }
        if (handler.isKeyPressed(KeyEvent.VK_SHIFT)) {
            camera.position.y += speed * dt;
        }
        if (handler.isKeyPressed(KeyEvent.VK_W)) {
            Vector dp = camera.front.copy();
            dp.y = 0;
            dp.normalize().scale(speed * dt);
            camera.position.add(dp);
        }
        if (handler.isKeyPressed(KeyEvent.VK_S)) {
            Vector dp = camera.front.copy();
            dp.y = 0;
            dp.normalize().scale(-speed * dt);
            camera.position.add(dp);
        }
        if (handler.isKeyPressed(KeyEvent.VK_A)) {
            Vector dp = camera.right.copy();
            dp.y = 0;
            dp.normalize().scale(-speed * dt);
            camera.position.add(dp);
        }
        if (handler.isKeyPressed(KeyEvent.VK_D)) {
            Vector dp = camera.right.copy();
            dp.y = 0;
            dp.normalize().scale(speed * dt);
            camera.position.add(dp);
        }
        if (handler.isKeyPressed(KeyEvent.VK_Q)) {
            camera.roll += angularSpeed * dt;
        }
        if (handler.isKeyPressed(KeyEvent.VK_E)) {
            camera.roll -= angularSpeed * dt;
        }
        camera.update();
        Arrays.sort(order, this :: compare);
        System.out.print("\r" + camera.roll + camera.position + camera.front);
    }

    private void render() {
        BufferStrategy bs = canvas.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        
        for (int i : order) {
            int[] pX = new int[3], pY = new int[3];
            int numBehind = 0;
            for (int j = i; j < i + 3; j++) {
                Vector projected = camera.project(vertices[indices[j]]);
                if (projected.z < 0) {
                    numBehind++;
                }
                pX[j - i] = (int) projected.x;
                pY[j - i] = (int) projected.y;
            }
            if (numBehind < 3) {
                Vector normal =
                        vertices[indices[i + 1]].copy().sub(vertices[indices[i]]).cross(vertices[indices[i + 2]].copy().sub(vertices[indices[i]]));
                normal.normalize();
                float intensity = (1 +camera.front.dot(normal)) / 2;
                Color color = Color.getHSBColor(212/255f, 79/255f, intensity);
                g.setColor(color);
                g.fillPolygon(pX, pY, 3);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("FPS: " + fps, 0, 10);

        g.dispose();
        bs.show();
    }
}