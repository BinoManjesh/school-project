package com.bino.graphics3d;

public class Camera {

	public Vector3 position;
	public int screenWidth, screenHeight;

	private Vector3 front;
	private Vector3 up;
	private Vector3 right;

	private double theta;

	private double k;

	public Camera(int screenWidth, int screenHeight) {
		position = new Vector3();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		front = new Vector3(0, 0, -1);
		up = new Vector3(0, 1, 0);
		right = new Vector3(1, 0, 0);
		theta = Math.PI / 2;
		k = screenWidth / (2 * Math.tan(theta / 2));
	}

	public Vector2 project(Vector3 v) {
		Vector3 t1 = v.copy().sub(position);
		Vector3 t2 = new Vector3();
		t2.x = t1.dot(right);
		t2.y = t1.dot(up);
		t2.z = t1.dot(front);

		Vector2 projected = new Vector2();
        projected.x = screenWidth / 2.0 + k * t2.x / t2.z;
        projected.y = screenHeight /2.0 - k * t2.y / t2.z;
        return projected;
	}
}
