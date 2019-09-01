package com.bino.snake;

import com.badlogic.gdx.graphics.Color;

class Constants {

    static final int WORLD_SIZE = 22;
    static final float BLOCK_SIZE = 0.9f;
    static final float BLOCK_FACTOR = (1 - BLOCK_SIZE) / 2f;

    private static final float SNAKE_SPEED = 10;
    static final float SNAKE_TIME_PERIOD = 1 / SNAKE_SPEED;

    static class Colors {

        static final Color BG_COLOR = Color.GRAY;
        static final Color SNAKE_COLOR = Color.BLACK;
        static final Color APPLE_COLOR = Color.RED;
        static final Color WALL_COLOR = Color.WHITE;
    }
}
