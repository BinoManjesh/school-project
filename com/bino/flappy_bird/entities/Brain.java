package com.bino.flappy_bird.entities;

import com.badlogic.gdx.math.MathUtils;

public class Brain {

    private float bias;
    private float[] weights;

    Brain() {
        bias = MathUtils.random(-100f, 100f);
        weights = new float[4];
        for (int i = 0; i < 4; i++) {
            weights[i] = MathUtils.random(-100f, 100f);
        }
    }

    Brain(Brain b1, Brain b2) {
        if (MathUtils.randomBoolean()) {
            bias = b1.bias;
        } else {
            bias = b2.bias;
        }
        weights = new float[4];
        for (int i = 0; i < 4; i++) {
            if (MathUtils.randomBoolean()) {
                weights[i] = b1.weights[i];
            } else {
                weights[i] = b2.weights[i];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(bias + "");
        for (float weight : weights) {
            builder.append(' ').append(weight);
        }
        return builder.toString();
    }

    boolean shouldJump(float... params) {
        float sum = bias;
        for (int i = 0; i < 3; i++) {
            sum += weights[i] * params[i];
        }
        return sum > 0;
    }
}
