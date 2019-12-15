package com.bino.multi_snake;

import com.badlogic.gdx.graphics.Color;

class Constants {

    static final int WORLD_SIZE = 500;

    static final float SNAKE_RADIUS = 10;
    static final float SNAKE_SPEED = 12 * SNAKE_RADIUS;
    static final float T = 0.01f;//(float) (2 * RADIUS_OF_CURVATURE * Math.atan(SNAKE_RADIUS / RADIUS_OF_CURVATURE));
    static final float MARGIN_OF_ERROR = 0.0001f;
    static final float FOOD_RADIUS = SNAKE_RADIUS;
    static final float DISTANCE_2 = (float) Math.pow(FOOD_RADIUS + SNAKE_RADIUS, 2);
    static final Color BG_COLOR = Color.BLACK;
    static final Color SNAKE_COLOR = Color.GREEN;
    static final Color FOOD_COLOR = Color.CORAL;
    private static final float RADIUS_OF_CURVATURE = 4 * SNAKE_RADIUS;
    static final float ANGULAR_VELOCITY = SNAKE_SPEED / RADIUS_OF_CURVATURE;
}
