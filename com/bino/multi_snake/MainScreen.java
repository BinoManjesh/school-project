package com.bino.multi_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class MainScreen extends ScreenAdapter {

    private ShapeRenderer renderer;
    private Viewport viewport;
    private Snake snake;
    private Food food;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        viewport.getCamera();
        snake = new Snake(new Vector2(Constants.WORLD_SIZE / 2f, Constants.WORLD_SIZE / 2f));
        food = new Food(viewport);

        Gdx.gl.glClearColor(Constants.BG_COLOR.r, Constants.BG_COLOR.g, Constants.BG_COLOR.b, Constants.BG_COLOR.a);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        food.init();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        snake.update(delta, food);
        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Line);
        food.draw(renderer);
        snake.draw(renderer);
        renderer.setColor(Color.RED);
        renderer.end();
    }

    @Override
    public void dispose() {

    }
}
