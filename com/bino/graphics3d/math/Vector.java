package com.bino.graphics3d.math;

public class Vector {

    public float x, y, z;

    public Vector() {}

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public Vector copy() {
        return new Vector(this);
    }

    public Vector rotateX(float theta) {
        Vector rotated = new Vector();
        float cos = (float)Math.cos(theta), sin = (float)Math.sin(theta);
        rotated.x = x;
        rotated.y = y * cos - z * sin;
        rotated.z = y * sin + z * cos;
        return rotated;
    }

    public Vector rotateY(float theta) {
        Vector rotated = new Vector();
        float cos = (float)Math.cos(theta), sin = (float)Math.sin(theta);
        rotated.x = z * sin + x * cos;
        rotated.y = y;
        rotated.z = z * cos - x * sin;
        return rotated;
    }

    public Vector rotateZ(float theta) {
        Vector rotated = new Vector();
        float cos = (float)Math.cos(theta), sin = (float)Math.sin(theta);
        rotated.x = x * cos - y * sin;
        rotated.y = x * sin + y * cos;
        rotated.z = z;
        return rotated;
    }

    public Vector add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vector add(Vector v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public Vector sub(Vector v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    public Vector sub(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public Vector cross(Vector v) {
        Vector cross = new Vector();
        cross.x = y * v.z - z * v.y;
        cross.y = z * v.x - x * v.z;
        cross.z = x * v.y - y * v.x;
        return cross;
    }

    public float dot(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector scale(float scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
        return this;
    }

    public Vector normalize() {
        float magnitude = (float)Math.sqrt(x*x + y*y + z*z);
        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
        return this;
    }
}
