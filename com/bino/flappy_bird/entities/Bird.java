package com.bino.flappy_bird.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.bino.flappy_bird.utils.Assets;
import com.bino.flappy_bird.utils.GlobalConstants;

import static com.bino.flappy_bird.utils.GlobalConstants.METRE;

public class Bird extends Sprite {

    private static final int X_VEL = METRE;
    private static final float GRAVITY = 9.8f * METRE;
    private static final float JUMP_VEL = 2.5f * METRE;
    private static final int HEIGHT = 17;

    public boolean alive;
    Vector2 velocity;

    public Bird() {
        super(Assets.bird);
        setOriginCenter();
        init();
    }

    void init() {
        setX(0);
        setY((GlobalConstants.WORLD_HEIGHT - getHeight()) / 2);
        velocity = new Vector2(X_VEL, 0);
        alive = true;
    }

    public void update(float delta, PipePair nearest) {
        float x = getX();
        float y = getY();

        velocity.y -= GRAVITY * delta;

        x += velocity.x * delta;
        y += velocity.y * delta;

        if (y > GlobalConstants.WORLD_HEIGHT - HEIGHT) {
            y = GlobalConstants.WORLD_HEIGHT - HEIGHT;
        } else if (y < 0) {
            y = 0;
            velocity.x = 0;
            alive = false;
        }
        if (nearest.overlaps(getBoundingRectangle())) {
            velocity.x = 0;
        }

        float angle = MathUtils.atan2(velocity.y, velocity.x) * MathUtils.radiansToDegrees;
        if (!Float.isNaN(angle)) {
            setRotation(angle);
        }

        setX(x);
        setY(y);
    }

    public void jump() {
        if (velocity.x != 0) {
            velocity.y = JUMP_VEL;
        }
    }
}
