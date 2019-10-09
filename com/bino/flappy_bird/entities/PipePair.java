package com.bino.flappy_bird.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.bino.flappy_bird.utils.Assets;
import com.bino.flappy_bird.utils.GlobalConstants;

class PipePair {

    private static final int GAP = 80;

    final float x;

    final Rectangle rect1;
    final Rectangle rect2;

    PipePair(float x) {
        this.x = x;

        final float h1 =
                MathUtils.random.nextFloat() * (GlobalConstants.WORLD_HEIGHT - GAP - GlobalConstants.PIPE_EDGE * 4) + GlobalConstants.PIPE_EDGE * 2;
        final float h2 = GlobalConstants.WORLD_HEIGHT - h1 - GAP;

        rect1 = new Rectangle(x, 0, GlobalConstants.PIPE_WIDTH, h1);
        rect2 = new Rectangle(x, h1 + GAP, GlobalConstants.PIPE_WIDTH, h2);
    }

    void draw(SpriteBatch batch) {
        Assets.pipe.draw(batch, rect1.x, rect1.y, rect1.width, rect1.height);
        Assets.pipe.draw(batch, rect2.x, rect2.y, rect2.width, rect2.height);
    }

    boolean overlaps(Rectangle rectangle) {
        return rect1.overlaps(rectangle) || rect2.overlaps(rectangle);
    }
}
