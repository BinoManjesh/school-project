package com.bino.flappy_bird;

import com.badlogic.gdx.graphics.Color;

class Constants {

    static final Color BG_COLOR = Color.SKY;
    static final int WORLD_WIDTH = 200;
    static final int WORLD_HEIGHT = 300;
    static final int BIRD_WIDTH = 20;
    static final int BIRD_HEIGHT = 17;
    static final float PIPE_WIDTH = 40;
    static final float PIPE_GAP = 80;
    static final int POPULATION_SIZE = 100_000;
    private static final float METRE = 100;
    static final float G = 9.8f * Constants.METRE;
    static final float BIRD_X_VEL = 1 * METRE;
    static final float BIRD_JUMP_VEL = 2.5f * METRE;
}
