package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

class Bird extends Sprite {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 17;
    
    private static final float G = 9.8f * GameScreen.METRE;
    private static final float X_VEL = 100;
    private static final float JUMP_VEL = 250;

    Vector2 vel;
    Rectangle rect;

    Bird(float y) {
    	super(Assets.instance.bird);
    	
        setPosition(0, y);
        setOriginCenter();
        vel = new Vector2(X_VEL, 0);
        rect = new Rectangle(0, y, WIDTH, HEIGHT);
    }

    void update(float delta) {
        float x = getX();
        float y = getY();
        vel.y -= G * delta;
        
        if (y <= 0) {
            setY(0);
            y = 0;
            vel.y = 0;
        }
        
        x += vel.x * delta;
        y += vel.y * delta;
        
        setX(x);
        setY(y);

        rect.setX(x);
        rect.setY(y);
        
        float angle = ((float) Math.atan(vel.y / vel.x)) * 180 / MathUtils.PI;
        if (angle == angle) {
        	setRotation(angle);
        }
    } 

     void jump() {
        vel.y = JUMP_VEL;
    }
}
