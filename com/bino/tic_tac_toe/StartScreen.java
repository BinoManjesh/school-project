package com.bino.tic_tac_toe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class StartScreen extends ScreenAdapter {

    private static final String TAG = StartScreen.class.getName();
    private static final Color BG_COLOR = Color.WHITE;
    private static final int TEXTURE_WIDTH = 29;
    private static final int TEXTURE_HEIGHT = 17;
    private static final int WORLD_WIDTH = TEXTURE_WIDTH * 3;
    private static final int WORLD_HEIGHT = TEXTURE_HEIGHT * 3;

    private Viewport viewport;
    private SpriteBatch batch;

    @Override
    public void show() {
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new Input());
        Gdx.gl.glClearColor(BG_COLOR.r,
                BG_COLOR.g,
                BG_COLOR.b,
                BG_COLOR.a);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        batch.draw(Assets.instance.humanVHuman, 0, TEXTURE_HEIGHT);
        batch.draw(Assets.instance.humanVBot, TEXTURE_WIDTH * 2, TEXTURE_HEIGHT);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        Gdx.app.log(TAG, "Resized: " + width + " " + height);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void humanVHuman() {
        Gdx.app.log(TAG, "humanVHuman");
        TicTacToeGame.game.setScreen(new GameScreen(null));
    }

    private void humanVBot() {
        TicTacToeGame.game.setScreen(new SelectScreen());
    }

    class Input extends InputAdapter {

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            if (screenX < Gdx.graphics.getWidth() / 2) {
                humanVHuman();
            } else {
                humanVBot();
            }

            return true;
        }
    }
}
