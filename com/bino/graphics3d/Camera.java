package com.bino.graphics3d;

import com.bino.graphics3d.math.*;
import java.awt.*;
import java.awt.event.*;

public class Camera extends MouseMotionAdapter {

	public Vector position;
	public float theta;
	public float pitch;
	public float yaw;
	public float roll;
	public int screenWidth, screenHeight;
	public Vector front;
	public Vector right;

	private float[][] combined;

	private Robot robot;

	private static final float sensitivity = 0.002f;

	public Camera(int screenWidth, int screenHeight) {
		position = new Vector();
		theta = (float)Math.PI / 2;

		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		front = new Vector();
		right = new Vector();
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.err.println("Robot Error"); 
		}

		update();
	}

	public void update() {
		float[][] translate = new float[][] {
			{1, 0, 0, -position.x},
			{0, 1, 0, -position.y},
			{0, 0, 1, -position.z},
			{0, 0, 0, 1}
		};

		float sinR = (float)Math.sin(-roll);
		float cosR = (float)Math.cos(-roll);
		float[][] rollMatrix = new float[][] {
			{cosR, -sinR, 0, 0},
			{sinR, cosR, 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}
		};

		float sinY = (float)Math.sin(-yaw);
		float cosY = (float)Math.cos(-yaw); 
		float[][] yawMatrix = new float[][] {
			{cosY, 0, sinY, 0},
			{0, 1, 0, 0},
			{-sinY, 0, cosY, 0},
			{0, 0, 0, 1}
		};

		float sinP = (float)Math.sin(-pitch);
		float cosP = (float)Math.cos(-pitch);
		float[][] pitchMatrix = new float[][] {
			{1, 0, 0, 0},
			{0, cosP, -sinP, 0},
			{0, sinP, cosP, 0},
			{0, 0, 0, 1}
		};

		float foo = screenWidth / (2 * (float)Math.tan(theta/2));
		float[][] project = new float[][] {
			{foo, 0, 0, 0},
			{0, foo, 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}
		};

		float[][] rotation = Matrix.multiply(pitchMatrix, Matrix.multiply(yawMatrix, rollMatrix));

		combined = Matrix.multiply(project, Matrix.multiply(rotation, translate));

		front.x = -cosP*sinY*cosR + sinP*sinR;
		front.y = -cosP*sinY*sinR + sinP*cosR;
		front.z = cosP*cosY;

		right.x = cosY*cosR;
		right.y = -cosY*sinR;
		right.z = sinY;
	}

	public Vector project(Vector v) {
		Vector projected = v.multiply(combined);
        projected.x /= projected.z;
        projected.y /= projected.z;
        projected.x += screenWidth / 2f;
        projected.y += screenHeight / 2f;
        return projected;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int dx = e.getX() - screenWidth / 2;
		int dy = e.getY() - screenHeight / 2;
		yaw += sensitivity * dx;
		pitch -= sensitivity * dy;
		robot.mouseMove(e.getXOnScreen() - dx, e.getYOnScreen() - dy);
	}
}
