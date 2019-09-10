package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

class Bird extends Sprite {

    Vector2 vel;
    boolean alive;
    Pipes pipes;

    Bird(Pipes pipes) {
        super(Assets.instance.bird);

        this.pipes = pipes;
        setPosition(0, Constants.WORLD_HEIGHT / 2f);
        setOriginCenter();
        vel = new Vector2(Constants.BIRD_X_VEL, 0);
        alive = true;
    }

    void update(float delta) {
        float x = getX();
        float y = getY();

        vel.y -= Constants.G * delta;

        if (y <= 0) {
            setY(0);
            y = 0;
            vel.y = 0;
            kill();
        } else if (y > Constants.WORLD_HEIGHT - getHeight()) {
            y = Constants.WORLD_HEIGHT - getHeight();
            setY(y);
        }

        x += vel.x * delta;
        y += vel.y * delta;

        setX(x);
        setY(y);

        float angle = MathUtils.atan2(vel.y, vel.x) * 180 / MathUtils.PI;
        if (angle == angle) {
            setRotation(angle);
        }
    }

    void jump() {
        if (alive) {
            vel.y = Constants.BIRD_JUMP_VEL;
        }
    }

    void kill() {
        alive = false;
        vel.x = 0;
    }
}
