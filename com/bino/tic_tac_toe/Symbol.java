package com.bino.tic_tac_toe;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

enum Symbol {

    X, O;

    Symbol other() {
        if (this == X) {
            return O;
        } else return X;
    }

    void draw(SpriteBatch batch, float x, float y) {
        if (this == X) {
            batch.draw(Assets.instance.x, x, y);
        } else if (this == O) {
            batch.draw(Assets.instance.o, x, y);
        }
    }
}
