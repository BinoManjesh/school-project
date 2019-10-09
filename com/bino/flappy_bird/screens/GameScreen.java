package com.bino.flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bino.flappy_bird.FlappyBirdGame;
import com.bino.flappy_bird.entities.Bird;

public class GameScreen extends MainScreen {

    private FlappyBirdGame game;
    private Bird bird;

    public GameScreen(FlappyBirdGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        bird = new Bird();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                bird.jump();

                return true;
            }

            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.SPACE) {
                    bird.jump();
                }

                return true;
            }
        });
    }

    @Override
    protected void update(float delta) {
        super.update(delta);
        bird.update(delta, pipes.nearest);
        if (!bird.alive) {
            game.start();
        }
        float x = bird.getX();
        setCameraPos(x);
    }

    @Override
    protected void drawSprites(SpriteBatch batch) {
        super.drawSprites(batch);
        bird.draw(batch);
    }
}
