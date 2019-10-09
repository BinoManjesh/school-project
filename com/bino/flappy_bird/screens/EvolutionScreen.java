package com.bino.flappy_bird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bino.flappy_bird.entities.Population;

public class EvolutionScreen extends MainScreen {

    private Population population;
    private boolean paused;

    @Override
    public void show() {
        super.show();
        population = new Population();
        paused = false;

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keycode) {
                paused = !paused;
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                paused = !paused;
                return true;
            }
        });
    }

    @Override
    void update(float delta) {
        if (paused) {
            return;
        }
        super.update(delta);
        population.update(delta, pipes);
        setCameraPos(population.firstBirdX);
    }

    @Override
    void drawSprites(SpriteBatch batch) {
        super.drawSprites(batch);
        population.draw(batch);
    }
}