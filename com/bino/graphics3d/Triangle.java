package com.bino.graphics3d;

class Triangle {

    Vector3[] points = new Vector3[3];

    Triangle() {}

    Triangle(Vector3 p1, Vector3 p2, Vector3 p3) {
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
    }

    Triangle copy() {
        Triangle copy = new Triangle();
        for (int i = 0; i < 3; ++i) {
            copy.points[0] = points[0].copy();
        }
        return copy;
    }
}
