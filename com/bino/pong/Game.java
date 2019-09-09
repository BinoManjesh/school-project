package com.bino.pong;

class Game extends com.badlogic.gdx.Game {
    
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
