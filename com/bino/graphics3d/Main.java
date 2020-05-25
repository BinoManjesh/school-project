package com.bino.graphics3d;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

class Main {

	private static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 500;

	public static void main(String[] args) {

		Mesh original = new Mesh("cube.obj");
		Mesh cube = original.copy();

		for (int i = 0; i < cube.triangles.size(); ++i) {
			for (int j = 0; j < 3; ++j) {
				cube.triangles.get(i).points[j] =
				original.triangles.get(i).points[j].add(0, 0, -10);
			}
		}

		JComponent c = new JComponent() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
				g.setColor(Color.BLACK);
				for (Triangle triangle : cube.triangles) {
					Vector2[] projected = new Vector2[3];
					double k = SCREEN_WIDTH / 2.0;
					for (int i = 0; i < 3; ++i) {
						projected[i] = project(k, triangle.points[i]);
						projected[i].x = SCREEN_WIDTH / 2.0 + projected[i].x;
						projected[i].y = SCREEN_HEIGHT / 2.0 - projected[i].y;
					}
					fillTriangle(g, projected);
				}
                // fillTriangle(g, new Vector2[] {new Vector2(700, 400), new Vector2(100, 400), new Vector2(0, 0)});
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

        // long prevTime = System.nanoTime();
        // double t1 = 0, t2 = 0;
        // while (true) {
        //     long thisTime = System.nanoTime();
        //     double dt = (thisTime - prevTime) * 1e-9;
        //     prevTime = thisTime;

        //     t1 += Math.PI * dt / 2;
        //     t2 += Math.PI * dt;



        //     c.repaint();
        // }
	}

	static void fillTriangle(Graphics g, Vector2[] p) {
		Arrays.sort(p, (a, b) -> (int)(a.y - b.y));

		int y = (int)p[0].y;
		double m1 = (p[0].x - p[1].x) / (p[0].y - p[1].y);
		double c1 = p[0].x - m1 * p[0].y;
		double m2 = (p[0].x - p[2].x) / (p[0].y - p[2].y);
		double c2 = p[0].x - m1 * p[0].y;
		while (y + 0.5 <= p[1].y) {
			double x1 = m1*(y + 0.5) + c1;
			double x2 = m2*(y + 0.5) + c2;
			g.drawLine((int)x1, y, (int)x2, y);
			y++;
		}
		m1 = (p[2].x - p[1].x) / (p[2].y - p[1].y);
		c1 = p[2].x - m1 * p[2].y;
		while (y + 0.5 <= p[2].y) {
			double x1 = m1*(y + 0.5) + c1;
			double x2 = m2*(y + 0.5) + c2;
			g.drawLine((int)x1, y, (int)x2, y);
			y++;
		}
	}

	static void drawTriangle(Graphics g, Vector2[] p) {
		for (int i = 0; i < 3; ++i) {
			int j = (i + 1) % 3;
			g.drawLine((int)p[i].x, (int)p[i].y, (int)p[j].x, (int)p[j].y);
		}
	}

	static Vector2 project(double k, Vector3 p) {
		Vector2 projected = new Vector2();
		projected.x = -k * p.x / p.z;
		projected.y = -k * p.y / p.z;
		return projected;
	}
}