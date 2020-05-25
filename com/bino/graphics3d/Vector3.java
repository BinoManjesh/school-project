package com.bino.graphics3d;

class Vector3 {

    double x, y, z;

    Vector3() {}

    Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector3(Vector3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    Vector3 copy() {
        return new Vector3(this);
    }

    Vector3 rotateZ(double theta) {
        Vector3 rotated = new Vector3();
        double cos = Math.cos(theta), sin = Math.sin(theta);
        rotated.x = x * cos - y * sin;
        rotated.y = x * sin + y * cos;
        rotated.z = z;
        return rotated;
    }

    Vector3 rotateX(double theta) {
        Vector3 rotated = new Vector3();
        double cos = Math.cos(theta), sin = Math.sin(theta);
        rotated.x = x;
        rotated.y = y * cos - z * sin;
        rotated.z = y * sin + z * cos;
        return rotated;
    }

    Vector3 add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
}
