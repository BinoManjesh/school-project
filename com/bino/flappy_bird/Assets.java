package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;

class Assets {
	
	static Assets instance;

    final Texture bird;
    final NinePatch pipe;
	
	private Assets () {
        bird = new Texture(Gdx.files.internal("assets/bird.png"));
        pipe = new NinePatch(new Texture(Gdx.files.internal("assets/pipe.png")), 0, 0, 6, 6);
	}
	
	static void init() {
		instance = new Assets();
	}
}
