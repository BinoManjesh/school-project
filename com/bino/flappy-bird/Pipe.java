package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

class Pipe {
	
	static final float WIDTH = 0.5f;
	private static final float GAP = WIDTH;
	private static final Color COLOR = Color.GREEN;
	
	float x;
	float y1, y2;
	
	Pipe(float x) {
		this.x = x;
		y1 = MathUtils.random.nextFloat() * (GameScreen.HEIGHT - GAP);
		y2 = GameScreen.HEIGHT - y1 - GAP;
	}
	
	void render(ShapeRenderer renderer) {
		renderer.setColor(COLOR);
		renderer.rect(x, 0, WIDTH, y1);
		renderer.rect(x, y1 + GAP, WIDTH, y2);
	}
}
