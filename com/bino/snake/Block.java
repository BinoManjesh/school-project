package com.bino.snake;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

class Block {

    Vector position;

    Block(Vector position) {
        this.position = new Vector(position);
    }

    void draw(ShapeRenderer renderer) {
        renderer.rect(position.x + Constants.BLOCK_FACTOR, position.y + Constants.BLOCK_FACTOR, Constants.BLOCK_SIZE,
                Constants.BLOCK_SIZE);
    }
}
