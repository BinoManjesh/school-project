package com.bino.tic_tac_toe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class SelectScreen extends ScreenAdapter {

    private static final int WORLD_SIZE = 60;

    private Viewport viewport;
    private SpriteBatch batch;

    @Override
    public void show() {
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new Input());
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        batch.draw(Assets.instance.x, 0, 20);
        batch.draw(Assets.instance.o, 40, 20);
        batch.end();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private class Input extends InputAdapter {

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            GameScreen screen;
            if (screenX < Gdx.graphics.getWidth() / 2) {
                screen = new GameScreen(Symbol.O);
            } else {
                screen = new GameScreen(Symbol.X);
            }
            TicTacToeGame.game.setScreen(screen);

            return true;
        }
    }
}
