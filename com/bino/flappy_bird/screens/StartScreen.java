package com.bino.flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bino.flappy_bird.FlappyBirdGame;
import com.bino.flappy_bird.utils.Assets;

public class StartScreen extends ScreenAdapter {

    private static final int WORLD_WIDTH = 96;
    private static final int WORLD_HEIGHT = 32;

    private FlappyBirdGame game;
    private SpriteBatch batch;
    private Viewport viewport;

    public StartScreen(FlappyBirdGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector2 touchPos = new Vector2(screenX, screenY);
                touchPos = viewport.unproject(touchPos);

                if (Assets.playBounds.contains(touchPos)) {
                    game.play();
                } else if (Assets.evolveBounds.contains(touchPos)) {
                    game.evolve();
                }

                return true;
            }
        });
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        Assets.play.draw(batch);
        Assets.evolve.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
