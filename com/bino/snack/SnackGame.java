package com.bino.snack;

import com.badlogic.gdx.Game;

public class SnackGame extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen());
    }
}
