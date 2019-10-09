package com.bino.flappy_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.bino.flappy_bird.screens.EvolutionScreen;
import com.bino.flappy_bird.screens.GameScreen;
import com.bino.flappy_bird.screens.StartScreen;
import com.bino.flappy_bird.utils.Assets;

public class FlappyBirdGame extends Game {

    private static final Color BG_COLOR = Color.SKY;

    @Override
    public void create() {
        Assets.init();
        Gdx.gl.glClearColor(BG_COLOR.r, BG_COLOR.g, BG_COLOR.b, BG_COLOR.a);
        start();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    public void start() {
        setScreen(new StartScreen(this));
    }

    public void play() {
        setScreen(new GameScreen(this));
    }

    public void evolve() {
        setScreen(new EvolutionScreen());
    }
}
