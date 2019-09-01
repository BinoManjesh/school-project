package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;

class Assets {
	
	static Assets instance;
	
	Texture bird;
	NinePatch pipe;
	
	private Assets () {
        bird = new Texture(Gdx.files.internal("assets/flappy_bird/bird.png"));
        Texture pipeTex = new Texture(Gdx.files.internal("assets/flappy_bird/pipe.png"));
		pipe = new NinePatch(pipeTex, 0, 0, 6, 6);
	}
	
	static void init() {
		instance = new Assets();
	}
}
