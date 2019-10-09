package com.bino.flappy_bird.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Population {

    private static final int POPULATION_SIZE = 100;

    public float firstBirdX;
    public int generation;
    public int aliveBirds;

    private SmartBird[] birds;

    public Population() {
        birds = new SmartBird[POPULATION_SIZE];
        for (int i = 0; i < POPULATION_SIZE; i++) {
            birds[i] = new SmartBird();
        }
        generation = 1;
        aliveBirds = POPULATION_SIZE;
    }

    public void update(float delta, Pipes pipes) {
        aliveBirds = 0;
        for (SmartBird bird : birds) {
            bird.update(delta, pipes.nearest);
            if (bird.alive) {
                aliveBirds++;
                firstBirdX = Math.max(bird.getX(), firstBirdX);
            }
        }
        if (aliveBirds == 0) {
            firstBirdX = 0;
            createNewGen();
            System.out.println(birds[0].brain);
            pipes.init();
        }
    }

    private void createNewGen() {
        generation++;
        sort();
        SmartBird[] newGen = new SmartBird[POPULATION_SIZE];
        for (int i = 0; i < (int) (POPULATION_SIZE * 0.8); i += 2) {
            newGen[i / 2 + (int) (POPULATION_SIZE * 0.2)] = new SmartBird(birds[i], birds[i + 1]);
        }
        for (int i = (int) (POPULATION_SIZE * 0.6); i < POPULATION_SIZE; i++) {
            newGen[i] = new SmartBird();
        }
        for (int i = 0; i < POPULATION_SIZE * 0.2f; i++) {
            birds[i].init();
            newGen[i] = birds[i];
        }
        birds = newGen;
    }

    private void sort() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            SmartBird fittest = birds[i];
            int index = i;
            for (int j = i + 1; j < POPULATION_SIZE; j++) {
                if (fittest.getX() < birds[j].getX()) {
                    fittest = birds[j];
                    index = j;
                }
            }
            birds[index] = birds[i];
            birds[i] = fittest;
        }
    }

    public void draw(SpriteBatch batch) {
        for (Bird bird : birds) {
            bird.draw(batch);
        }
    }
}
