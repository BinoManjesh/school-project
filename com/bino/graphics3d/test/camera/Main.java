package com.bino.graphics3d.test.camera;

import com.bino.graphics3d.Camera;
import com.bino.graphics3d.util.*;
import com.bino.graphics3d.math.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Main {

	private static final int SCREEN_WIDTH = 300, SCREEN_HEIGHT = SCREEN_WIDTH / 16 * 9;

	private Camera camera;
	private Canvas canvas;
	private ArrayList<Vector> vertices;
	private ArrayList<Integer> indices;

	private Main() {
		canvas = new Canvas();
		vertices = new ArrayList<>();
		indices = new ArrayList<>();
		MeshLoader.load("3d objects/teapot.obj", vertices, indices);

		JFrame frame = new JFrame("Camera Test");

		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);

		canvas.addKeyListener(new KeyHandler());
		frame.add(canvas);
		frame.pack();
		canvas.createBufferStrategy(3);

		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void run() {
		long lastTime = System.nanoTime();
		while(true) {
			long thisTime = System.nanoTime();
			float dt = (thisTime - lastTime) * 1e-9f; 
			update(dt);
			render();
		}
	}

	private void update(float dt) {
		
	}

	private void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();

		

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}