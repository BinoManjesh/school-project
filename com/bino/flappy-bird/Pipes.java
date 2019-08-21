package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;

class Pipes {
	
	private static final float GAP = 2;
		
	private Queue<Pipe> pipes;
	private Bird bird;
	private float distance;
	
	Pipes(Bird bird) {
		pipes = new Queue<Pipe>();
		pipes.addFirst(new Pipe(GameScreen.WIDTH));
		
		this.bird = bird;
	}
	
	void update() {
		Gdx.app.log("Pipes", "" + pipes.size);
		
		float screenLeft = bird.pos.x - GameScreen.WIDTH / 4f;
		float screenRight = GameScreen.WIDTH + screenLeft;
		
		Pipe last = pipes.last();
		if (last.x + Pipe.WIDTH < screenLeft) {
			pipes.removeLast();
		}
		
		Pipe first = pipes.first();
		
		if (bird.pos.x + Bird.RADIUS > pipe.)
		
		Gdx.app.log("Pipes", "" + (screenRight - first.x));
		if (screenRight - first.x - Pipe.WIDTH > GAP) {
			pipes.addFirst(new Pipe(screenRight));
		}
		
		
	}
	
	void render(ShapeRenderer renderer) {
		for (Pipe pipe : pipes) {
			pipe.render(renderer);
		}
	}
}
