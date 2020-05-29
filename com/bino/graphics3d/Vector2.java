package com.bino.graphics3d;

class Vector2 {

    double x, y;

    Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vector2() {}

    @Override
    public String toString() {
        return String.format("(x: %d, y: %d)", x, y);
    }
}
