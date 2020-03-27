package com.bino.gravitation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

class MainScreen extends ScreenAdapter {

    private static final int WORLD_SIZE = 100;

    Viewport viewport;
    Camera camera;
    ArrayList<Planet> planets;

    boolean pause;
    float epochs = 2000;
    private ShapeRenderer renderer;

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        camera = viewport.getCamera();
        planets = new ArrayList<>();
        pause = true;
        Gdx.input.setInputProcessor(new InputManager(this));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (!pause) {
            for (int i = 0; i < epochs; ++i) {
                for (Planet planet : planets) {
                    planet.update(delta, planets);
                }
                for (Planet planet1 : planets) {
                    for (Planet planet2 : planets) {
                        if (planet1 != planet2) {
                            planet1.collide(planet2);
                        }
                    }
                }
            }
        }

        renderer.setProjectionMatrix(camera.combined);
        viewport.apply();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Planet planet : planets) {
            planet.draw(renderer);
        }
        renderer.end();
    }

    @Override
    public void dispose() {
    }
}
