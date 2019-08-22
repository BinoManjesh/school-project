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
        float screenLeft = bird.pos.x - GameScreen.WIDTH / 4f;
        float screenRight = GameScreen.WIDTH + screenLeft;

        Pipe last = pipes.last();
        if (last.x + Pipe.WIDTH < screenLeft) {
            pipes.removeLast();
            last = pipes.last();
        }
        
        if (last.rect1.collides(bird.rect) || last.rect2.collides(bird.rect)) {
        	bird.pos.y = 0;
        }

        Pipe first = pipes.first();

        if (screenRight - first.x - Pipe.WIDTH > GAP) {
            pipes.addFirst(new Pipe(screenRight));
        }
    }
    
    void render(ShapeRenderer renderer) {
    	for(Pipe pipe : pipes) {
    		pipe.render(renderer);
    	}
    }
}
