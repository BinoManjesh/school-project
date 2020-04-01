package com.bino.round_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

class Snake {

    private static final int SEG_SIZE = 50;
    private static final int VEL = 500;
    private static final int RADIUS_OF_CURVATURE = 500;
    private static final int ACC = VEL * VEL / RADIUS_OF_CURVATURE;

    private Segment head;

    private ArrayList<Segment> segments;

    Snake() {
        head = new Segment(new Vector2(500, 1000));
        head.velocity.x = VEL;
        segments = new ArrayList<>();
    }

    void update(float delta) {
        float foo = ACC / head.velocity.len();
        head.velocity.x += head.velocity.y * foo * delta;
        head.velocity.y -= head.velocity.x * foo * delta;
        Gdx.app.log("VEL", "" + head.velocity.len());
        //        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
        //            head.velocity.y += 100 * delta;
        //        }
        //        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
        //            head.velocity.x -= 100 * delta;
        //        }
        //        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
        //            head.velocity.y -= 100 * delta;
        //        }
        //        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
        //            head.velocity.x += 100 * delta;
        //        }
        Segment s2 = head;
        for (Segment s1 : segments) {
            s1.velocity.x = s2.position.x - s1.position.x;
            s1.velocity.y = s2.position.y - s1.position.y;
            float scalar = s2.velocity.dot(s1.velocity) / s1.velocity.len2();
            s1.velocity.x *= scalar;
            s1.velocity.y *= scalar;
            s2 = s1;
        }
        head.update(delta);
        for (Segment s : segments) {
            s.update(delta);
        }
    }

    void draw(ShapeRenderer renderer) {
        head.draw(renderer);
        for (Segment s : segments) {
            s.draw(renderer);
        }
    }

    static class Segment {

        Vector2 velocity;
        Vector2 position;

        Segment(Vector2 position) {
            this.position = position;
            velocity = new Vector2();
        }

        void update(float delta) {
            position.x += velocity.x * delta;
            position.y += velocity.y * delta;
        }

        void draw(ShapeRenderer renderer) {
            renderer.circle(position.x, position.y, SEG_SIZE);
        }
    }
}
