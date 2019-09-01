package com.bino.snake;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

class CustomViewport extends ExtendViewport {

    CustomViewport(float worldWidth, float worldHeight) {
        super(worldWidth, worldHeight);
    }

    @Override
    public void update(int screenWidth, int screenHeight, boolean centerCamera) {
        super.update(screenWidth, screenHeight, centerCamera);
        if (screenWidth < screenHeight) {
            setScreenY(screenHeight - screenWidth);
        }
    }
}
