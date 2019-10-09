package com.bino.gravitation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class MainScreen extends ScreenAdapter {

    static final float METRE = 1.563e-6f;
    private static final int INIT_WORLD_SIZE = 250;
    private static final Color BG = Color.SKY;

    private Viewport viewport;
    private Camera camera;
    private ShapeRenderer renderer;

    private Satellite satellite;
    private InputManager manager;

    @Override
    public void show() {
        viewport = new FillViewport(INIT_WORLD_SIZE, INIT_WORLD_SIZE);
        camera = viewport.getCamera();
        renderer = new ShapeRenderer();

        satellite = new Satellite();
        manager = new InputManager(viewport, camera, satellite);

        Gdx.input.setInputProcessor(manager);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        manager.resize();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(BG.r, BG.g, BG.b, BG.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manager.update(delta);
        float epochs = manager.epochs;

        while (epochs > 0) {
            satellite.update(delta);
            epochs--;
        }

        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        satellite.draw(renderer);
        manager.draw(renderer);
        renderer.end();
    }
}
