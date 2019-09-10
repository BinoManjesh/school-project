package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;

class Pipes {

    private static final float GAP = 80;
    PipePair nearest;
    private Viewport viewport;
    private Camera camera;
    private Queue<PipePair> pipes;
    private int index;

    Pipes(Viewport viewport) {
        this.viewport = viewport;
        camera = viewport.getCamera();
        pipes = new Queue<>();
        nearest = new PipePair(Constants.WORLD_WIDTH);
        pipes.addFirst(nearest);
        index = -1;
    }

    void update() {
        final float width = viewport.getWorldWidth();
        final float screenLeft = camera.position.x - width / 2;
        final float screenRight = screenLeft + width;
        PipePair last = pipes.last();
        PipePair first = pipes.first();
        while (screenRight - first.x - Constants.PIPE_WIDTH > GAP) {
            first = new PipePair(first.x + Constants.PIPE_WIDTH + GAP);
            pipes.addFirst(first);
            index++;
            if (last.x + Constants.PIPE_WIDTH < screenLeft) {
                pipes.removeLast();
                last = pipes.last();
            }
        }

        final float birdX = camera.position.x - Constants.WORLD_WIDTH / 4f;
        if (nearest.x + Constants.PIPE_WIDTH < birdX) {
            nearest = pipes.get(index);
            index--;
        }
    }

    void draw(SpriteBatch batch) {
        for (PipePair pipe : pipes) {
            pipe.draw(batch);
        }
    }
}