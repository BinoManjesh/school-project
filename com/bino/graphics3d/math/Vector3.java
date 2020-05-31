package com.bino.graphics3d;

class Vector3 {

    float x, y, z;

    Vector3() {}

    Vector3(float x, float y, float z) {
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

    Vector3 rotateX(float theta) {
        Vector3 rotated = new Vector3();
        float cos = (float)Math.cos(theta), sin = (float)Math.sin(theta);
        rotated.x = x;
        rotated.y = y * cos - z * sin;
        rotated.z = y * sin + z * cos;
        return rotated;
    }

    Vector3 rotateY(float theta) {
        Vector3 rotated = new Vector3();
        float cos = (float)Math.cos(theta), sin = (float)Math.sin(theta);
        rotated.x = z * sin + x * cos;
        rotated.y = y;
        rotated.z = z * cos - x * sin;
        return rotated;
    }

    Vector3 rotateZ(float theta) {
        Vector3 rotated = new Vector3();
        float cos = (float)Math.cos(theta), sin = (float)Math.sin(theta);
        rotated.x = x * cos - y * sin;
        rotated.y = x * sin + y * cos;
        rotated.z = z;
        return rotated;
    }

    Vector3 add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    Vector3 add(Vector3 v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    Vector3 sub(Vector3 v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    Vector3 sub(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    Vector3 cross(Vector3 v) {
        Vector3 cross = new Vector3();
        cross.x = y * v.z - z * v.y;
        cross.y = z * v.x - x * v.z;
        cross.z = x * v.y - y * v.x;
        return cross;
    }

    float dot(Vector3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    Vector3 scale(float scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
        return this;
    }

    Vector3 normalize() {
        float magnitude = (float)Math.sqrt(x*x + y*y + z*z);
        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
        return this;
    }
}
