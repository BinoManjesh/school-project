package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;

class Rectangle {
    
    float left, down;
    float right, up;
    float width, height;
    
    Rectangle (float x, float y, float width, float height) {
        this.left = x;
        this.down = y;
        this.width = width;
        this.height = height;
        right = left + width;
        up = down + height;
    }
    
    void setX(float x) {
        left = x;
        right = left + width;
    }
    
    void setY(float y) {
        down = y;
        up = down + height;
    }
    
    boolean collides(Rectangle rect) {
        return collidesInX(rect) && collidesInY(rect);
    }
    
    private boolean collidesInX(Rectangle rect) {
        Gdx.app.log("Collision", "" + Math.abs(this.left - rect.right));
        return Math.abs(this.left - rect.right) < this.width + rect.width;
    }
    
    private boolean collidesInY(Rectangle rect) {
        return Math.abs(this.down - rect.up) < this.height + rect.height;
    }
}
