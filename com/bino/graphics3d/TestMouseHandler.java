package com.bino.graphics3d;

import java.awt.event.*;

class TestMouseHandler extends MouseAdapter {

	Vector2[] p;
	int RADIUS;
	Vector2 selected;

	TestMouseHandler(Vector2[] p, int RADIUS) {
		this.p = p;
		this.RADIUS = RADIUS;
		selected = null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		selected = null;
		double x = e.getX() + 0.5, y = e.getY() + 0.5;
		for (Vector2 point : p) {
			if (Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2) < RADIUS * RADIUS) {
				selected = point;
				break;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (selected != null) {
			selected.x = e.getX() + 0.5;
			selected.y = e.getY() + 0.5;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		selected = null;
	}
}