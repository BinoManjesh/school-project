package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

class Pipe {

    static final float WIDTH = 0.5f;
    private static final float GAP = WIDTH;
    private static final Color COLOR = Color.GREEN;

    final float x;
    final float y1, y2;
    final Rectangle rect1;
    final Rectangle rect2;

    Pipe(float x) {
        this.x = x;
        y1 = MathUtils.random.nextFloat() * (GameScreen.HEIGHT - GAP);
        y2 = GameScreen.HEIGHT - y1 - GAP;
        
        rect1 = new Rectangle(x, 0, WIDTH, y1);
        rect2 = new Rectangle(x, y1 + GAP, WIDTH, y2);
        Gdx.app.log("New pipe1", rect1.left + " " + rect1.down + " " + rect1.width + " " + rect1.height);
        Gdx.app.log("New pipe2", rect2.left + " " + rect2.down + " " + rect2.width + " " + rect2.height);
    }

    void render(ShapeRenderer renderer) {
        renderer.setColor(COLOR);
        renderer.rect(rect1.left, rect1.down, rect1.width, rect1.height);
        renderer.rect(rect2.left, rect2.down, rect2.width, rect2.height);
    }
}
