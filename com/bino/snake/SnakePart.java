package com.bino.snake;

class SnakePart extends Block {

    SnakePart(Vector position) {
        super(position);
    }

    void update(SnakePart part) {
        position = new Vector(part.position);
    }
}
