package com.bino.snake;

import com.badlogic.gdx.Game;

public class SnakeGame extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen());
    }
}
