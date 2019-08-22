package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;

class Pipes {

    private static final float GAP = 2;

    private Queue<Pipe> pipes;
    private Bird bird;
    private float distance;
    private Pipe nearest;

    Pipes(Bird bird) {
        pipes = new Queue<Pipe>();
        nearest = new Pipe(GameScreen.WIDTH);
        pipes.addFirst(nearest);

        this.bird = bird;
    }

    void update() {
        float screenLeft = bird.pos.x - GameScreen.WIDTH / 4f;
        float screenRight = GameScreen.WIDTH + screenLeft;

        Pipe last = pipes.last();
        if (last.x + Pipe.WIDTH < screenLeft) {
            pipes.removeLast();
        }

        Pipe first = pipes.first();
        if (nearest.rect1.collides(bird.rect) && nearest.rect2.collides(bird.rect)) {
            Gdx.app.log("Pipes", "boom");
            bird.pos.y = 0;
            nearest = first;
        }

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
