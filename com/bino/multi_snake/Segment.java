package com.bino.multi_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

class Segment {

    private static String TAG = Segment.class.getName();

    Segment next;
    float t;
    int dir;
    Vector2 position;
    Vector2 velocity;

    Segment(Vector2 initPosition, Vector2 initVelocity, int initDir) {
        dir = initDir;
        position = initPosition;
        velocity = initVelocity;
    }

    void update(float delta) {
        Gdx.app.log(TAG, "t: " + t);
        velocity.rotateRad(dir * Constants.ANGULAR_VELOCITY * delta);
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
        t -= delta;
        if (Math.abs(t) <= Constants.MARGIN_OF_ERROR) {
            Gdx.app.log(TAG, "YES" + t);
            dir *= -1;
            if (next != null)
                next.t = Constants.T;
        }
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(Constants.SNAKE_COLOR);
        renderer.circle(position.x, position.y, Constants.SNAKE_RADIUS);
    }
}
