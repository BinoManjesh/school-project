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
        float cos = (float) Math.cos(theta), sin = (float) Math.sin(theta);
        rotated.x = x;
        rotated.y = y * cos - z * sin;
        rotated.z = y * sin + z * cos;
        return rotated;
    }

    public Vector rotateY(float theta) {
        Vector rotated = new Vector();
        float cos = (float) Math.cos(theta), sin = (float) Math.sin(theta);
        rotated.x = z * sin + x * cos;
        rotated.y = y;
        rotated.z = z * cos - x * sin;
        return rotated;
    }

    public Vector rotateZ(float theta) {
        Vector rotated = new Vector();
        float cos = (float) Math.cos(theta), sin = (float) Math.sin(theta);
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

    public Vector multiply(float[][] matrix) {
        Vector product = new Vector();
        product.x = matrix[0][0] * x + matrix[0][1] * y + matrix[0][2] * z + matrix[0][3];
        product.y = matrix[1][0] * x + matrix[1][1] * y + matrix[1][2] * z + matrix[1][3];
        product.z = matrix[2][0] * x + matrix[2][1] * y + matrix[2][2] * z + matrix[2][3];
        return product;
    }

    public Vector normalize() {
        float magnitude = magnitude();
        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
        return this;
    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return String.format("[%f, %f, %f]", x, y, z);
    }
}
