package com.bino.graphics3d.math;

public class Matrix {

	public static float[][] multiply(float[][] a, float[][] b) {
		float[][] c = new float[4][4];
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				for (int k = 0; k < 4; ++k) {
					c[i][j] += a[i][k] * b[k][j]; 
				}
			}
		}
		return c;
	}
}