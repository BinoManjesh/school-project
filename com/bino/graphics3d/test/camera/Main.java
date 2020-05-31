package com.bino.graphics3d.test.camera;

import com.bino.graphics3d.Camera;
import java.awt.*;

public class Main {

	private static final int SCREEN_WIDTH = 300, SCREEN_HEIGHT = SCREEN_WIDTH / 16 * 9;

	private Camera camera;
	private Canvas canvas;

	private Main() {
		canvas = new Canvas;
		JFrame frame = new JFrame("Camera Test");

		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);

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

	private void update(float dt) {}

	private void render() {}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}