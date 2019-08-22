package com.bino.flappy_bird;

import com.badlogic.gdx.Game;

class FlappyBirdGame extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }
    
    @Override
    public void render() {
    	System.out.println("Nain");
    	super.render();
    } 
}