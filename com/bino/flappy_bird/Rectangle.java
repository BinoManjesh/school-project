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
        return this.left < rect.right && rect.left < this.right;
    }
    
    private boolean collidesInY(Rectangle rect) {
        return this.down < rect.up && rect.down < this.up;
    }
}
