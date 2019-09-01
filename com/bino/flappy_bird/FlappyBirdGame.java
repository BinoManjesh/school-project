package com.bino.flappy_bird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class FlappyBirdGame extends Game {
	
	private static final Color BG_COLOR = Color.SKY;

    @Override
    public void create() {
    	Assets.init();
    	Gdx.gl.glClearColor(BG_COLOR.r, BG_COLOR.g, BG_COLOR.b, BG_COLOR.a);
        setScreen(new GameScreen());
    }
    
    @Override
    public void render() {
    	super.render();
    } 
}