package com.bino.flappy_bird.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.bino.flappy_bird.utils.GlobalConstants;

public class Pipes {

    private static final int GAP = 100;
    private static final int FIRST_DISTANCE = GlobalConstants.WORLD_HEIGHT;

    public PipePair nearest;
    public int score;

    private Queue<PipePair> pipes;
    private int index;

    public Pipes() {
        init();
    }

    void init() {
        pipes = new Queue<>();
        nearest = new PipePair(FIRST_DISTANCE);
        pipes.addFirst(nearest);
        score = 0;
        index = 0;
    }

    public void update(float width, float x) {
        System.out.println(index);
        final float screenLeft = x - width / 2;
        final float screenRight = screenLeft + width;
        PipePair last = pipes.last();
        PipePair first = pipes.first();
        while (screenRight - first.x - GlobalConstants.PIPE_WIDTH > GAP) {
            first = new PipePair(first.x + GlobalConstants.PIPE_WIDTH + GAP);
            pipes.addFirst(first);
            index++;
            if (last.x + GlobalConstants.PIPE_WIDTH < screenLeft) {
                pipes.removeLast();
                last = pipes.last();
            }
        }

        final float birdX = x - width / 4;
        if (nearest.x + GlobalConstants.PIPE_WIDTH < birdX) {
            nearest = pipes.get(--index);
            score++;
        }
    }

    public void draw(SpriteBatch batch) {
        for (PipePair pipe : pipes) {
            pipe.draw(batch);
        }
    }
}
