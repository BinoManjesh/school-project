package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

class Pipe {

    static final float WIDTH = 40;
    private static final float GAP = 80;
    private static final Color COLOR = Color.GREEN;

    final float x;
    final Rectangle rect1;
    final Rectangle rect2;

    Pipe(float x) {
    	this.x = x;
        float y1 = MathUtils.random.nextFloat() * (GameScreen.HEIGHT - GAP - 24) + 12;
        float y2 = GameScreen.HEIGHT - y1 - GAP;
        
        rect1 = new Rectangle(x, 0, WIDTH, y1);
        rect2 = new Rectangle(x, y1 + GAP, WIDTH, y2);
    }

    void draw(SpriteBatch batch) {
    	Assets.instance.pipe.draw(batch, rect1.left, rect1.down, rect1.width, rect1.height);
        Assets.instance.pipe.draw(batch, rect2.left, rect2.down, rect2.width, rect2.height);
    }
}
