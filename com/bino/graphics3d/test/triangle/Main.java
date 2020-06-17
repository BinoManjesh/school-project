//package com.bino.graphics3d.test.triangle;
//
//import java.awt.*;
//import java.awt.image.*;
//import javax.swing.*;
//
//class Test {
//
//	private static final int WIDTH = 1000, HEIGHT = WIDTH / 16 * 9;
//	private static final int RADIUS = 10;
//
//	public static void main(String[] args) throws Exception {
//		Vector2[] p = new Vector2[] {new Vector2(10, 10), new Vector2(100, 10), new Vector2(10, 100)};
//		String title = "Triangle Test";
//
//		Canvas canvas = new Canvas();
//		JFrame frame = new JFrame();
//		SwingUtilities.invokeAndWait(() -> {
//			Dimension size = new Dimension(WIDTH, HEIGHT);
//			frame.setMaximumSize(size);
//			frame.setMinimumSize(size);
//			frame.setTitle(title);
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setLocationRelativeTo(null);
//			frame.setResizable(false);
//			frame.add(canvas);
//			frame.pack();
//			canvas.createBufferStrategy(3);
//			TestMouseHandler handler = new TestMouseHandler(p, RADIUS);
//			canvas.addMouseListener(handler);
//			canvas.addMouseMotionListener(handler);
//			canvas.setBackground(Color.BLACK);
//			frame.setVisible(true);
//		});
//
//		int frames = 0;
//		float timer = System.currentTimeMillis();
//		while(true) {
//			BufferStrategy bs = canvas.getBufferStrategy();
//			Graphics g = bs.getDrawGraphics();
//
//			g.setColor(Color.BLACK);
//			g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//			g.setColor(Color.RED);
//			Renderer.drawTriangle(g, p);
//			g.setColor(Color.WHITE);
//			Renderer.fillTriangle(g, p);
//			g.setColor(Color.RED);
//			Renderer.drawTriangle(g, p);
//			for (Vector2 point : p) {
//				g.drawOval((int)point.x - RADIUS, (int)point.y - RADIUS, 2*RADIUS, 2*RADIUS);
//			}
//			frames++;
//			if (System.currentTimeMillis() - timer >= 1000) {
//				timer += 1000;
//				frame.setTitle(title + " | FPS: " + frames);
//				frames = 0;
//			}
//
//			g.dispose();
//			bs.show();
//		}
//	}
//}