package com.bino.multi_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

class Food {

    private static final String TAG = Food.class.getName();

    private Vector2 position;
    private Viewport viewport;

    Food(Viewport viewport) {
        this.viewport = viewport;
        position = new Vector2();
        init();
    }

    void init() {
        position.x =
                Constants.SNAKE_RADIUS + (viewport.getWorldWidth() - Constants.SNAKE_RADIUS * 2) * MathUtils.random();
        position.y =
                Constants.SNAKE_RADIUS + (viewport.getWorldHeight() - Constants.SNAKE_RADIUS * 2) * MathUtils.random();
        Gdx.app.log(TAG, position + "");
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(Constants.FOOD_COLOR);
        renderer.circle(position.x, position.y, Constants.FOOD_RADIUS);
    }

    boolean collidesWith(Vector2 snakePosition) {
        return position.dst2(snakePosition) < Constants.DISTANCE_2;
    }
}
