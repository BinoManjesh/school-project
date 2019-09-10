package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;

class Population {

    private SmartBird[] birds;
    private Pipes pipes;
    private Camera camera;

    Population(Pipes pipes, Viewport viewport) {
        birds = new SmartBird[Constants.POPULATION_SIZE];
        for (int i = 0; i < Constants.POPULATION_SIZE; i++) {
            birds[i] = new SmartBird(pipes);
        }
        this.pipes = pipes;
        this.camera = viewport.getCamera();
    }

    boolean update(float delta) {
        boolean areAllDead = true;
        for (SmartBird bird : birds) {
            bird.update(delta);
            if (bird.alive) {
                Rectangle rectangle = bird.getBoundingRectangle();
                if (rectangle.overlaps(pipes.nearest.rect1) || rectangle.overlaps(pipes.nearest.rect2)) {
                    bird.kill();
                } else {
                    areAllDead = false;
                    camera.position.x = bird.getX() + Constants.WORLD_WIDTH / 4f;
                }
            }
        }
        if (areAllDead) {
            camera.position.x = Constants.WORLD_WIDTH / 4f;
            createNewGen();

            return true;
        }
        return false;
    }

    private void createNewGen() {
        sort();
        SmartBird[] newGen = new SmartBird[Constants.POPULATION_SIZE];
        System.arraycopy(birds, 0, newGen, 0, (int) (Constants.POPULATION_SIZE * 0.2));
        for (int i = 0; i < (int) (Constants.POPULATION_SIZE * 0.8); i += 2) {
            newGen[i / 2 + (int) (Constants.POPULATION_SIZE * 0.2)] = new SmartBird(pipes, birds[i], birds[i + 1]);
        }
        for (int i = (int) (Constants.POPULATION_SIZE * 0.6); i < Constants.POPULATION_SIZE; i++) {
            newGen[i] = new SmartBird(pipes);
        }
        birds = newGen;
        System.out.println(birds[0]);
    }

    private void sort() {
        for (int i = 0; i < Constants.POPULATION_SIZE; i++) {
            SmartBird fittest = birds[i];
            int index = i;
            for (int j = i + 1; j < Constants.POPULATION_SIZE; j++) {
                if (fittest.getX() < birds[i].getX()) {
                    fittest = birds[i];
                    index = i;
                }
            }
            birds[index] = birds[i];
            birds[i] = fittest;
        }
    }

    void draw(SpriteBatch batch) {
        for (Bird bird : birds) {
            bird.draw(batch);
        }
    }
}
