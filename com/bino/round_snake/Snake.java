package com.bino.round_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import static com.badlogic.gdx.math.MathUtils.cos;
import static com.badlogic.gdx.math.MathUtils.sin;

class Snake {

    private static final int SEG_SIZE = 10;
    private static final int VEL = 500;
    private static final int RADIUS_OF_CURVATURE = 100;
    private static final int ACC = VEL * VEL / RADIUS_OF_CURVATURE;
    private static final int SEP_DISTANCE = SEG_SIZE * 2;

    private Segment head;
    private Vector2 headVel;

    private ArrayList<Segment> segments;

    Snake() {
        head = new Segment(new Vector2(500, 500), 0);
        headVel = new Vector2();
        headVel.x = VEL;
        segments = new ArrayList<>();
        final int numSegments = 100;
        Vector2 prevPos = head.position;
        for (int i = 0; i < numSegments; i++) {
            Segment s = new Segment(0, prevPos);
            segments.add(s);
            prevPos = s.position;
        }
    }

    void update(float delta) {
        float foo = ACC / headVel.len();
        int dir = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            dir = -1;
        }
        headVel.x += dir * foo * headVel.y * delta;
        headVel.y -= dir * foo * headVel.x * delta;
        head.position.mulAdd(headVel, delta);
        Vector2 prevVel = headVel;
        Vector2 prevPos = head.position;
        for (Segment s : segments) {
            Vector2 r = prevPos.cpy().sub(s.position);
            float scalar = prevVel.dot(r) / r.len2();
            Vector2 to = r.cpy().scl(scalar);
            Vector2 away = prevVel.cpy().sub(to);
            int sign = (int) Math.signum(to.x * away.y - to.y * away.x);
            s.theta += sign * away.len() / SEP_DISTANCE * delta;
            s.update(prevPos);
            prevVel = to;
            prevPos = s.position;
        }
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(Color.RED);
        head.draw(renderer);
        renderer.setColor(Color.WHITE);
        for (Segment s : segments) {
            s.draw(renderer);
        }
    }

    static class Segment {

        Vector2 position;
        float theta;

        Segment(float theta, Vector2 prev) {
            this.theta = theta;
            position = new Vector2();
            this.update(prev);
        }

        Segment(Vector2 position, float theta) {
            this.position = position;
            this.theta = theta;
        }

        void update(Vector2 prev) {
            position.x = prev.x - SEP_DISTANCE * cos(theta);
            position.y = prev.y - SEP_DISTANCE * sin(theta);
        }

        void draw(ShapeRenderer renderer) {
            renderer.circle(position.x, position.y, SEG_SIZE);
        }
    }
}
