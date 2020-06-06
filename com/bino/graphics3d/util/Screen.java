package com.bino.graphics3d.util;

public class Screen {

    public int drawColor;

    private int width, height;
    private int[] pixels;
    private float[] zBuffer;

    public Screen(int width, int height, int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
        zBuffer = new float[width * height];
    }

    public void clear() {
        for (int i = 0; i < width * height; ++i) {
            pixels[i] = 0;
            zBuffer[i] = Float.MAX_VALUE;
        }
    }

    public void drawLine(int x1, int x2, int y, float z1, float z2) {
        if (x1 < 0) {
            x1 = 0;
        }
        if (x2 > width - 1) {
            x2 = width - 1;
        }
        for (int i = y * width + x1; i < y * width + x2; ++i) {
            float z = (z2 - z1) / (x2 - x1) * (i - y * width - x1);
            if (z > 0 && zBuffer[i] > z) {
                zBuffer[i] = z;
                pixels[i] = drawColor;
            }
        }
    }
}
