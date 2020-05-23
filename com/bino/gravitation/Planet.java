package com.bino.gravitation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

class Planet extends Circle {

    private static final float G = 1;

    static float velocity_scale = 0.08f;
    static Planet selected;

    private Vector2 velocity;
    private Vector2 acceleration;
    private float mass;

    private Planet() {
        x = 0;
        y = 0;
        radius = 10;
        mass = radius * radius * radius;
        velocity = new Vector2();
        acceleration = new Vector2();
    }

    Planet(Vector2 position) {
        this();
        x = position.x;
        y = position.y;
    }

    void scaleRadius(float scl) {
        radius *= scl;
        mass *= scl * scl * scl;
    }

    void setVelocityX(float f) {
        velocity.x = f;
    }

    void setVelocityY(float f) {
        velocity.y = f;
    }

    void update(float delta) {
        velocity.x += acceleration.x * delta;
        velocity.y += acceleration.y * delta;
        x += velocity.x;
        y += velocity.y;
    }

    void setAcceleration(ArrayList<Planet> planets) {
        acceleration.set(0, 0);
        for (Planet planet : planets) {
            if (planet != this) {
                float dst = Vector2.dst(x, y, planet.x, planet.y);
                Vector2 unit = new Vector2();
                unit.x = (planet.x - x) / dst;
                unit.y = (planet.y - y) / dst;
                float magnitude = G * planet.mass / (dst * dst);
                acceleration.x += unit.x * magnitude;
                acceleration.y += unit.y * magnitude;
            }
        }
    }

    void collide(Planet planet2) {
        if (overlaps(planet2)) {
            final Planet planet1 = this;

            Vector2 p1 = new Vector2(planet1.x, planet1.y), p2 = new Vector2(planet2.x, planet2.y);
            Vector2 v1 = planet1.velocity, v2 = planet2.velocity;
            float m1 = planet1.mass, m2 = planet2.mass;

            float dst = Vector2.dst(planet1.x, planet1.y, planet2.x, planet2.y);
            float distToMove = (planet1.radius + planet2.radius - dst) / 2;
            Vector2 impact_unit = new Vector2((planet2.x - planet1.x) / dst, (planet2.y - planet1.y) / dst);
            float impact_v1 = v1.dot(impact_unit);
            float impact_v2 = v2.dot(impact_unit);
            planet1.x -= (planet2.x - planet1.x) / dst * distToMove * impact_v1 / (impact_v2 + impact_v1);
            planet1.y -= (planet2.y - planet1.y) / dst * distToMove * impact_v1 / (impact_v2 + impact_v1);
            planet2.x += (planet2.x - planet1.x) / dst * distToMove * impact_v2 / (impact_v2 + impact_v1);
            planet2.y += (planet2.y - planet1.y) / dst * distToMove * impact_v2 / (impact_v2 + impact_v1);

            //            Gdx.app.log("INITIAL MOMENTUM", "" + (v1.x * m1 + v2.x * m2) + " " + (v1.y * m1 + v2.y * m2));

            float dst2 = Vector2.dst2(p1.x, p1.y, p2.x, p2.y);
            float foo = dst2 * (m1 + m2);
            float dot1 = m2 * ((v1.x - v2.x) * (p1.x - p2.x) + (v1.y - v2.y) * (p1.y - p2.y)) / foo;
            float dot2 = m1 * ((v2.x - v1.x) * (p2.x - p1.x) + (v2.y - v1.y) * (p2.y - p1.y)) / foo;

            v1.x = v1.x - (p1.x - p2.x) * dot1;
            v1.y = v1.y - (p1.y - p2.y) * dot1;

            v2.x = v2.x - (p2.x - p1.x) * dot2;
            v2.y = v2.y - (p2.y - p1.y) * dot2;
            //            Gdx.app.log("FINAL MOMENTUM", "" + (v1.x * m1 + v2.x * m2) + " " + (v1.y * m1 + v2.y * m2));
        }
    }


    void draw(ShapeRenderer renderer) {
        if (this == selected) {
            renderer.setColor(Color.RED);
        } else {
            renderer.setColor(Color.WHITE);
        }
        renderer.circle(x, y, radius, 360);
        renderer.setColor(Color.BLUE);
        renderer.rectLine(x, y, x + velocity.x / velocity_scale, y + velocity.y / velocity_scale, radius / 10);
    }

    @Override
    public String toString() {
        return "Force/Momentum: (" + acceleration.x * mass + ", " + acceleration.y * mass + ")/(" + velocity.x * mass + ", " + velocity.y * mass + ")";
    }
}
