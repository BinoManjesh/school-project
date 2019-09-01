package com.bino.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

class Wall {

    private Block[] blocks;

    Wall() {
        blocks = new Block[2 * (2 * (Constants.WORLD_SIZE - 1))];
        int i = 0;
        for (int j = 0; j < Constants.WORLD_SIZE; j++) {
            blocks[i++] = new Block(new Vector(j, 0));
            blocks[i++] = new Block(new Vector(j, Constants.WORLD_SIZE - 1));
        }

        for (int j = 1; j < Constants.WORLD_SIZE - 1; j++) {
            blocks[i++] = new Block(new Vector(0, j));
            blocks[i++] = new Block(new Vector(Constants.WORLD_SIZE - 1, j));
        }
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(Constants.Colors.WALL_COLOR);
        for (Block block : blocks) {
            block.draw(renderer);
        }
    }
}
