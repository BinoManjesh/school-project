package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

abstract class MainScreen extends ScreenAdapter {

    Viewport viewport;
    Camera camera;
    Pipes pipes;
    private SpriteBatch batch;

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new ExtendViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        camera = viewport.getCamera();
    }

    void init() {
        camera.position.x = 0;
        pipes = new Pipes(viewport);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        pipes.update();

        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        pipes.draw(batch);
        drawSprites(batch);
        batch.end();
    }

    protected abstract void drawSprites(SpriteBatch batch);
}
