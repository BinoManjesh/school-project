package com.bino.snake;

class Vector {

    int x;
    int y;

    Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Vector(Vector v) {
        x = v.x;
        y = v.y;
    }

    boolean equals(Vector v) {
        return x == v.x && y == v.y;
    }
}
