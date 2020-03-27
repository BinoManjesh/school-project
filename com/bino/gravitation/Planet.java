package com.bino.gravitation;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

class Planet extends Circle {

    private static final float METRE = 0.000001f;
    private static final float DENSITY = 5.51e3f / METRE / METRE / METRE;
    private static final float G = 6.67408e-11f * METRE * METRE * METRE;

    static float velocity_scale = 0.00001f;
    static Planet selected;

    Vector2 velocity;
    private float mass;

    private Planet() {
        x = 0;
        y = 0;
        radius = 6.371e6f * METRE;
        mass = DENSITY * 4 / 3 * MathUtils.PI * radius * radius * radius;
        velocity = new Vector2();
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

    void update(float delta, ArrayList<Planet> planets) {
        Vector2 acceleration = getAcceleration(planets);
        velocity.mulAdd(acceleration, delta);
        x += velocity.x;
        y += velocity.y;
    }

    private Vector2 getAcceleration(ArrayList<Planet> planets) {
        Vector2 acceleration = new Vector2();
        for (Planet planet : planets) {
            if (planet != this) {
                float dst = Vector2.dst(x, y, planet.x, planet.y);
                Vector2 unit = new Vector2();
                unit.x = (planet.x - x) / dst;
                unit.y = (planet.y - y) / dst;
                float magnitude = G * planet.mass / (dst * dst);
                acceleration.mulAdd(unit, magnitude);
            }
        }
        return acceleration;
    }

    void collide(Planet planet2) {
        if (overlaps(planet2)) {
            final Planet planet1 = this;

            //Moves the balls away from each other
            float dst = Vector2.dst(planet1.x, planet1.y, planet2.x, planet2.y);
            float distToMove = (planet1.radius + planet2.radius - dst) / 2;
            planet1.x -= (planet2.x - planet1.x) / dst * distToMove;
            planet1.y -= (planet2.y - planet1.y) / dst * distToMove;
            planet2.x += (planet2.x - planet1.x) / dst * distToMove;
            planet2.y += (planet2.y - planet1.y) / dst * distToMove;

            //Changes the velocities of the balls
            Vector2 p1 = new Vector2(planet1.x, planet1.y), p2 = new Vector2(planet2.x, planet2.y);
            Vector2 v1 = planet1.velocity, v2 = planet2.velocity;
            float m1 = planet1.radius, m2 = planet2.radius;

            float dst2 = Vector2.dst2(p1.x, p1.y, p2.x, p2.y);
            float foo = dst2 * (m1 + m2);
            float dot1 = m2 * ((v1.x - v2.x) * (p1.x - p2.x) + (v1.y - v2.y) * (p1.y - p2.y)) / foo;
            float dot2 = m1 * ((v2.x - v1.x) * (p2.x - p1.x) + (v2.y - v1.y) * (p2.y - p1.y)) / foo;

            v1.x = v1.x - (p1.x - p2.x) * dot1;
            v1.y = v1.y - (p1.y - p2.y) * dot1;

            v2.x = v2.x - (p2.x - p1.x) * dot2;
            v2.y = v2.y - (p2.y - p1.y) * dot2;
        }
    }

    void draw(ShapeRenderer renderer) {
        if (this == selected) {
            renderer.setColor(Color.RED);
        } else {
            renderer.setColor(Color.WHITE);
        }
        renderer.circle(x, y, radius, 20);
        renderer.setColor(Color.BLUE);
        renderer.rectLine(x, y, x + velocity.x / velocity_scale, y + velocity.y / velocity_scale, radius / 10);
    }
}
