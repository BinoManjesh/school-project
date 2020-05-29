package com.bino.graphics3d;

class Triangle {

    Vector3[] points = new Vector3[3];
    Vector3 normal;

    Triangle() {}

    Triangle(Vector3 p1, Vector3 p2, Vector3 p3) {
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        Vector3 t1 = p2.copy().sub(p1);
        Vector3 t2 = p3.copy().sub(p1);
        normal = t2.cross(t1);
        normal.normalize();
    }

    Triangle copy() {
        Triangle copy = new Triangle();
        for (int i = 0; i < 3; ++i) {
            copy.points[0] = points[0].copy();
        }
        copy.normal = normal.copy();
        return copy;
    }

    int zSum() {
        double sum = 0;
        for (Vector3 point : points) {
            sum += point.z;
        }
        return (int)sum;
    }
}
