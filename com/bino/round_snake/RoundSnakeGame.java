package com.bino.round_snake;

import com.badlogic.gdx.Game;

public class RoundSnakeGame extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen());
    }
}
