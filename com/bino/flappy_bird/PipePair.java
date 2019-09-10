package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

class PipePair {

    final float x;

    Rectangle rect1;
    Rectangle rect2;

    PipePair(float x) {
        this.x = x;
        final float h1 = MathUtils.random.nextFloat() * (Constants.WORLD_HEIGHT - Constants.PIPE_GAP - 24) + 12;
        final float h2 = Constants.WORLD_HEIGHT - h1 - Constants.PIPE_GAP;

        rect1 = new Rectangle(x, 0, Constants.PIPE_WIDTH, h1);
        rect2 = new Rectangle(x, h1 + Constants.PIPE_GAP, Constants.PIPE_WIDTH, h2);
    }

    void draw(SpriteBatch batch) {
        Assets.instance.pipe.draw(batch, rect1.x, rect1.y, rect1.width, rect1.height);
        Assets.instance.pipe.draw(batch, rect2.x, rect2.y, rect2.width, rect2.height);
    }
}
