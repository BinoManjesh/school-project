package com.bino.gravitation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import static com.bino.gravitation.MainScreen.METRE;

class Satellite {

    private static final float G = 6.67e-11f * METRE * METRE * METRE;
    private static final float M = 5.972e24f;
    private static final float R = 6.4e6f * METRE;

    static final float RADIUS = R / 10;

    private static final Color COLOR = Color.BLACK;
    private static final Circle EARTH = new Circle(0, 0, R);

    Vector2 position;
    Vector2 velocity;

    boolean alive;
    private Circle circle;

    Satellite() {
        init();
    }

    void init() {
        position = new Vector2(0, R + RADIUS);
        velocity = new Vector2();
        alive = false;
        circle = new Circle(0, R, RADIUS);
    }

    void update(float delta) {
        if (alive) {
            Vector2 acceleration = getAcceleration();
            velocity.mulAdd(acceleration, delta);
            position.mulAdd(velocity, delta);
            circle.setPosition(position);
            if (circle.overlaps(EARTH)) {
                alive = false;
            }
        }
    }

    private Vector2 getAcceleration() {
        float dst2 = position.dst2(0, 0);
        if (dst2 == 0) {
            return new Vector2();
        }
        final float dst = (float) Math.sqrt(dst2);
        Vector2 unit = new Vector2();
        unit.x = -position.x / dst;
        unit.y = -position.y / dst;
        final float mag = G * M / (dst * dst);
        return unit.scl(mag);
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(Color.GREEN);
        renderer.circle(0, 0, R, 30);
        renderer.setColor(COLOR);
        renderer.circle(position.x, position.y, RADIUS, 30);
    }
}
