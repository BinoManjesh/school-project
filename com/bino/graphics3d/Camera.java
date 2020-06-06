package com.bino.graphics3d;

import com.bino.graphics3d.math.*;

public class Camera {

	public Vector position;
	public float theta;
	public Vector front;
	public Vector up;
	public Vector right;
	public int screenWidth, screenHeight;

	private float[][] translate;
	private float[][] rotate;
	private float[][] project;
	private float[][] combined;


	public Camera(int screenWidth, int screenHeight) {
		position = new Vector();
		theta = (float)Math.PI / 2;

		front = new Vector(0, 0, -1);
		up = new Vector(0, 1, 0);
		right = new Vector(1, 0, 0);

		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		translate = new float[4][4];
		for (int i = 0; i < 4; ++i) {
			translate[i][i] = 1;
		}

		rotate = new float[4][4];
		rotate[3][3] = 1;

		project = new float[4][4];
		project[2][2] = 1;
		project[3][3] = 1;

		combined = new float[4][4];

		update();
	}

	public void update() {
		translate[0][2] = -position.x;
		translate[1][2] = -position.y;
		translate[2][2] = -position.z;

		rotate[0][0] = right.x;
		rotate[0][1] = right.y;
		rotate[0][2] = right.z;

		rotate[1][0] = up.x;
		rotate[1][1] = up.y;
		rotate[1][2] = up.z;

		rotate[2][0] = -front.x;
		rotate[2][1] = -front.y;
		rotate[2][2] = -front.z;

		project[0][0] = screenWidth / (float)Math.tan(theta/2);
		project[1][1] = project[0][0];

		combined = Matrix.multiply(project, Matrix.multiply(rotate, translate));
	}

	public Vector project(Vector v) {
		Vector projected = new Vector();
        projected.x = v.x * combined[0][0] + v.y * combined[0][1] + v.z * combined[0][2] + combined[0][3];
        projected.y = v.x * combined[1][0] + v.y * combined[1][1] + v.z * combined[1][2] + combined[1][3];
        projected.z = v.x * combined[2][0] + v.y * combined[2][1] + v.z * combined[2][2] + combined[2][3];
        projected.x /= projected.z;
        projected.y /= projected.z;
        return projected;
	}
}
