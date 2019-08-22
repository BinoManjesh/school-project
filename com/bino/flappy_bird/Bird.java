package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

class Bird extends InputAdapter {

    private static final Color COLOR = Color.ORANGE;
    private static final float RADIUS = 0.1f;
    private static final float G = 9.8f;
    private static final float X_VEL = 1;
    private static final float JUMP_VEL = 3;

    Vector2 pos;
    private Vector2 vel;
    Rectangle rect;

    Bird(float y) {
        pos = new Vector2(0, y);
        vel = new Vector2(X_VEL, 0);
        final float DIAMETER = RADIUS * 2;
        rect = new Rectangle(pos.x - RADIUS, pos.y - RADIUS, DIAMETER, DIAMETER);

        Gdx.input.setInputProcessor(this);
    }

    void update(float delta) {
        vel.y -= G * delta;

        pos.mulAdd(vel, delta);

        if (pos.y < RADIUS) {
            pos.y = RADIUS;
            vel.y = 0;
        }
        
        rect.setX(pos.x - RADIUS);
        rect.setY(pos.y - RADIUS);
    } 

    void render(ShapeRenderer renderer) {
        renderer.setColor(COLOR);
        renderer.circle(pos.x, pos.y, RADIUS, 30);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        vel.y = JUMP_VEL;

        return true;
    }
}
