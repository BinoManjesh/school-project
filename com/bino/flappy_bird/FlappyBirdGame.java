package com.bino.flappy_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class FlappyBirdGame extends Game {

    static FlappyBirdGame game;

    @Override
    public void create() {
        game = this;
    	Assets.init();
        Gdx.gl.glClearColor(Constants.BG_COLOR.r, Constants.BG_COLOR.g, Constants.BG_COLOR.b, Constants.BG_COLOR.a);
        setScreen(new EvolutionScreen());
    }
}
