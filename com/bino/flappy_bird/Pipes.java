package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;

class Pipes {

    private static final float GAP = 80;

    private Queue<Pipe> pipes;
    private Bird bird;
    private Viewport viewport;
    private float distance;
    private Pipe nearest;
    private int index;

    Pipes(Bird bird, Viewport viewport) {
    	this.bird = bird;
        this.viewport = viewport;
        
        pipes = new Queue<Pipe>();
        nearest = new Pipe(GameScreen.WIDTH);
        pipes.addFirst(nearest);
        index = -1;
    }

    void update() {
    	float width = viewport.getWorldWidth();
        float screenLeft = bird.getX() - width / 4;
        float screenRight = width + screenLeft;
        Pipe last = pipes.last();
        Pipe first = pipes.first();
        if (screenRight - first.x - Pipe.WIDTH > GAP) {
            pipes.addFirst(new Pipe(first.x + Pipe.WIDTH + GAP));
            index++;
            if (last.x + Pipe.WIDTH < screenLeft) {
            	pipes.removeLast();
            	last = pipes.last();
            }
        }
        
        if (nearest.x + Pipe.WIDTH < bird.getX()) {
        	nearest = pipes.get(index);
        	index--;
        } else if (nearest.rect1.collides(bird.rect) || nearest.rect2.collides(bird.rect)) {
        	bird.kill();
        }
    }
    
    void draw(SpriteBatch batch) {
    	for(Pipe pipe : pipes) {
    		pipe.draw(batch);
    	}
    }
}
