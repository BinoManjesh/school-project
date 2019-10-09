package com.bino.flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bino.flappy_bird.entities.Pipes;
import com.bino.flappy_bird.utils.Assets;
import com.bino.flappy_bird.utils.GlobalConstants;

abstract class MainScreen extends ScreenAdapter {

    private static final int MIN_WORLD_WIDTH = 200;

    private static final int N_CHARACTERS = 10;
    private static final int TEXT_VIEWPORT_SIZE = 7 * N_CHARACTERS - 1;

    Pipes pipes;

    private Viewport spritesViewport;
    private SpriteBatch batch;
    private Camera spritesCamera;
    private Viewport textViewport;

    private Camera textCamera;

    @Override
    public void show() {
        batch = new SpriteBatch();

        spritesViewport = new ExtendViewport(MIN_WORLD_WIDTH, GlobalConstants.WORLD_HEIGHT, Float.POSITIVE_INFINITY,
                GlobalConstants.WORLD_HEIGHT);
        spritesCamera = spritesViewport.getCamera();

        textViewport = new FitViewport(TEXT_VIEWPORT_SIZE, TEXT_VIEWPORT_SIZE);
        textCamera = textViewport.getCamera();

        pipes = new Pipes();
    }

    @Override
    public void resize(int width, int height) {
        spritesViewport.update(width, height, true);
        textViewport.update(width, height, true);

        if (height > width) {
            spritesViewport.setScreenY(height - spritesViewport.getScreenHeight());
            textViewport.setScreenY(height - textViewport.getScreenHeight());
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);

        spritesViewport.apply();
        batch.setProjectionMatrix(spritesCamera.combined);

        batch.begin();
        drawSprites(batch);
        batch.end();

        textViewport.apply();
        batch.setProjectionMatrix(textCamera.combined);

        batch.begin();
        drawText(batch, textViewport.getWorldWidth(), textViewport.getWorldHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    void update(float delta) {
        pipes.update(spritesViewport.getWorldWidth(), spritesCamera.position.x);
    }

    void drawSprites(SpriteBatch batch) {
        pipes.draw(batch);
    }

    private void drawText(SpriteBatch batch, float width, float height) {
        GlyphLayout score = new GlyphLayout(Assets.font, "" + pipes.score);
        Assets.font.draw(batch, score, (width - score.width) / 2, (height - score.height) / 2);
    }

    void setCameraPos(float x) {
        spritesCamera.position.x = x + spritesViewport.getWorldWidth() / 4;
    }
}
