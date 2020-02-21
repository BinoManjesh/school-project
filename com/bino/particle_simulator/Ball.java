package com.bino.particle_simulator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

class Ball extends Circle {

    private static final String TAG = Ball.class.getName();
    private static final float DRAG = 0;
    private static final float E = 1;

    static Viewport viewport;
    static Ball dragged;

    private final Color COLOR;

    Vector2 velocity;

    Ball(Vector2 position, float radius) {
        super(position, radius);
        COLOR = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 0.999f);
        velocity = new Vector2();
    }

    void update(float dt) {
        if (this == dragged) {
            return;
        }
        velocity.x -= velocity.x * DRAG * dt;
        velocity.y -= (velocity.y * DRAG) * dt;
        x += velocity.x * dt;
        y += velocity.y * dt;
        collideWithWalls();
    }

    private void collideWithWalls() {
        float worldWidth = viewport.getWorldWidth(), worldHeight = viewport.getWorldHeight();

        if (x > worldWidth - radius) {
            x = worldWidth - radius;
            velocity.x *= -E;
        } else if (x < radius) {
            x = radius;
            velocity.x *= -E;
        }

        if (y > worldHeight - radius) {
            y = worldHeight - radius;
            velocity.y *= -E;
        } else if (y < radius) {
            y = radius;
            velocity.y *= -E;
        }
    }

    void collideWithBall(Ball ball2) {
        if (overlaps(ball2)) {
            final Ball ball1 = this;

            //Moves the balls away from each other
            float dst = Vector2.dst(ball1.x, ball1.y, ball2.x, ball2.y);
            float distToMove = (ball1.radius + ball2.radius - dst) / 2;
            if (ball1 == dragged) {
                ball2.x += (ball2.x - ball1.x) / dst * distToMove * 2;
                ball2.y += (ball2.y - ball1.y) / dst * distToMove * 2;
            } else if (ball2 == dragged) {
                ball1.x -= (ball2.x - ball1.x) / dst * distToMove * 2;
                ball1.y -= (ball2.y - ball1.y) / dst * distToMove * 2;
            } else {
                ball1.x -= (ball2.x - ball1.x) / dst * distToMove;
                ball1.y -= (ball2.y - ball1.y) / dst * distToMove;
                ball2.x += (ball2.x - ball1.x) / dst * distToMove;
                ball2.y += (ball2.y - ball1.y) / dst * distToMove;
            }

            //Changes the velocities of the balls
            Vector2 p1 = new Vector2(ball1.x, ball1.y), p2 = new Vector2(ball2.x, ball2.y);
            Vector2 v1 = ball1.velocity, v2 = ball2.velocity;
            float m1 = ball1.radius, m2 = ball2.radius;

            float dst2 = Vector2.dst2(p1.x, p1.y, p2.x, p2.y);
            float foo = (E + 1) / (dst2 * (m1 + m2));
            float dot1 = foo * m2 * ((v1.x - v2.x) * (p1.x - p2.x) + (v1.y - v2.y) * (p1.y - p2.y));
            float dot2 = foo * m1 * ((v2.x - v1.x) * (p2.x - p1.x) + (v2.y - v1.y) * (p2.y - p1.y));

            v1.x = v1.x - (p1.x - p2.x) * dot1;
            v1.y = v1.y - (p1.y - p2.y) * dot1;

            v2.x = v2.x - (p2.x - p1.x) * dot2;
            v2.y = v2.y - (p2.y - p1.y) * dot2;

            float dist = Vector2.dst(ball1.x, ball1.y, ball2.x, ball2.y);
            float radiusSum = ball1.radius + ball2.radius;
            if (dist < radiusSum * 0.9f) {
                Gdx.app.log(TAG, "Collision failed" +
                        "\nRadius sum: " + radiusSum +
                        "\nDistance between: " + dist);
            }
        }
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(COLOR);
        renderer.circle(x, y, radius);
        renderer.setColor(Color.BLACK);
        float mag = velocity.len();
        if (mag >= 1) {
            renderer.rectLine(x, y, x + velocity.x / mag * radius, y + velocity.y / mag * radius, radius / 10);
        } else {
            velocity.scl(0);
        }
    }
}
