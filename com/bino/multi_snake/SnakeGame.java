package com.bino.multi_snake;

import com.badlogic.gdx.Game;

public class SnakeGame extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen());
    }

    @Override
    public void pause() {

    }
}
