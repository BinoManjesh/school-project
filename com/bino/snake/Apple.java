package com.bino.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

class Apple extends Block {

    private static Random random = new Random();

    private Apple(Vector position) {
        super(position);
    }

    static Apple getNewApple() {
        int x = getRandomCoordinate();
        int y = getRandomCoordinate();
        return new Apple(new Vector(x, y));
    }

    private static int getRandomCoordinate() {
        return (int) (random.nextFloat() * (Constants.WORLD_SIZE - 2) + 1);
    }

    @Override
    void draw(ShapeRenderer renderer) {
        renderer.setColor(Constants.Colors.APPLE_COLOR);
        super.draw(renderer);
    }
}
