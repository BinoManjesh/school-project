package com.bino.graphics3d;

class Vector2 {

    float x, y;

    Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Vector2() {}

    @Override
    public String toString() {
        return String.format("(x: %d, y: %d)", x, y);
    }
}
