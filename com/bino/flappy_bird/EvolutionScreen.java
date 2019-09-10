package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class EvolutionScreen extends MainScreen {

    private Population population;
    private boolean shouldPause;

    @Override
    public void show() {
        super.show();
        init();
        shouldPause = true;
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                shouldPause = !shouldPause;
                return true;
            }
        });
    }

    @Override
    void init() {
        super.init();
        population = new Population(pipes, viewport);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (shouldPause) {
            return;
        }
        if (population.update(delta)) {
            init();
        }
    }

    @Override
    protected void drawSprites(SpriteBatch batch) {
        population.draw(batch);
    }
}
