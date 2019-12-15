package com.bino.multi_snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

class Snake {

    private Segment head;

    Snake(Vector2 initPosition) {
        head = new Segment(initPosition, new Vector2(Constants.SNAKE_SPEED, 0), 1);
    }

    void update(float delta, Food food) {
        head.t = Constants.T + Constants.MARGIN_OF_ERROR;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            if (head.next != null && head.dir != -1)
                head.next.t = Constants.T;
            head.dir = -1;
        } else {
            if (head.next != null && head.dir != 1)
                head.next.t = Constants.T;
            head.dir = 1;
        }
        head.update(delta);

        Segment segment = head.next, last = head;
        while (true) {
            if (segment == null) {
                break;
            } else {
                last = segment;
                segment.update(delta);
                segment = segment.next;
            }
        }
        if (food.collidesWith(head.position)) {
            last.next = new Segment(new Vector2(last.position), new Vector2(last.velocity), last.dir);
            food.init();
        }
    }

    void draw(ShapeRenderer renderer) {
        Segment segment = head;
        while (segment != null) {
            segment.draw(renderer);
            segment = segment.next;
        }
    }
}
