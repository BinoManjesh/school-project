package com.bino.gravitation;

import com.badlogic.gdx.Game;

public class GravitationGame extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen());
    }
}
