package com.bino.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

class MainScreen implements Screen {

    private ShapeRenderer renderer;
    private CustomViewport viewport;
    private Snake snake;
    private Apple apple;
    private Wall wall;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        viewport = new CustomViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        snake = new Snake(viewport);
        apple = Apple.getNewApple();
        wall = new Wall();

        Gdx.gl.glClearColor(Constants.Colors.BG_COLOR.r,
                Constants.Colors.BG_COLOR.g,
                Constants.Colors.BG_COLOR.b,
                Constants.Colors.BG_COLOR.a);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        if (snake.update(delta, apple.position)) {
            apple = Apple.getNewApple();
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        apple.draw(renderer);
        snake.draw(renderer);
        wall.draw(renderer);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
