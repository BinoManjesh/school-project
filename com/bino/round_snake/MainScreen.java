package com.bino.round_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class MainScreen extends ScreenAdapter {

    ShapeRenderer renderer;
    Viewport viewport;

    Snake snake;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(1000, 1000);
        snake = new Snake();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        snake.update(delta);

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        snake.draw(renderer);
        renderer.end();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
