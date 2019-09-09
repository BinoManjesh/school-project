package com.bino.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

class GameScreen extends ScreenAdapter {
    
    private static final int SIZE = 100;
    private static final Color BG_COLOR = Color.WHITE;
    
    private Viewport viewport;
    private ShapeRenderer renderer;
    
    @Override
    public void show() {
        viewport = new ExtendViewport(SIZE, SIZE);
        renderer = new ShapeRenderer();
    }
    
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(BG_COLOR.r, BG_COLOR.g, BG_COLOR.b, BG_COLOR.a);
    }
}
