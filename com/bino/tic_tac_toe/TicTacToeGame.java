package com.bino.tic_tac_toe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class TicTacToeGame extends Game {

    static TicTacToeGame game;

    public TicTacToeGame() {
        game = this;
    }

    @Override
    public void create() {
        Gdx.graphics.setContinuousRendering(false);
        Assets.instance.init();
        setScreen(new StartScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
