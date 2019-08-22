package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FillViewport;

class GameScreen extends ScreenAdapter {

    static final int WIDTH = 6;
    static final int HEIGHT = 4;

    private ShapeRenderer renderer;
    private Viewport viewport;
    private Camera camera;
    private Bird bird;
    private Pipes pipes;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        viewport = new FillViewport(WIDTH, HEIGHT);
        camera = viewport.getCamera();
        bird = new Bird(HEIGHT / 2);
        pipes = new Pipes(bird);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        bird.update(delta);
        pipes.update();
        camera.position.x = bird.pos.x + WIDTH / 4f;

        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        pipes.render(renderer);
        bird.render(renderer);
        renderer.end();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
