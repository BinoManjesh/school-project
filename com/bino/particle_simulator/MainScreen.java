package com.bino.particle_simulator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import static com.bino.particle_simulator.Ball.dragged;

class MainScreen extends ScreenAdapter {

    private Viewport viewport;
    private ShapeRenderer renderer;
    private ArrayList<Ball> balls;
    private float ballSize;
    private boolean shooting;

    @Override
    public void show() {
        viewport = new ExtendViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        Ball.viewport = viewport;
        renderer = new ShapeRenderer();
        balls = new ArrayList<Ball>();
        ballSize = 0.1f * Constants.METRE;
        shooting = false;

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector2 touchPos = viewport.unproject(new Vector2(screenX, screenY));
                dragged = null;
                for (Ball ball : balls) {
                    if (ball.contains(touchPos)) {
                        dragged = ball;
                        dragged.velocity.scl(0);
                    }
                }
                if (button == Input.Buttons.RIGHT && dragged != null) {
                    shooting = true;
                } else if (button == Input.Buttons.LEFT) {
                    if (dragged == null) {
                        balls.add(new Ball(touchPos, ballSize));
                    } else {
                        dragged.setPosition(touchPos);
                    }
                }
                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                if (!shooting && dragged != null) {
                    Vector2 touchPos = viewport.unproject(new Vector2(screenX, screenY));
                    dragged.setPosition(touchPos);
                }

                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (shooting) {
                    Vector2 touchPos = viewport.unproject(new Vector2(screenX, screenY));
                    dragged.velocity.x = (dragged.x - touchPos.x) / dragged.radius * 1000;
                    dragged.velocity.y = (dragged.y - touchPos.y) / dragged.radius * 1000;
                    shooting = false;
                }
                dragged = null;

                return true;
            }
        });
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Constants.BG_COLOR.r, Constants.BG_COLOR.g, Constants.BG_COLOR.b, Constants.BG_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (Ball ball : balls) {
            ball.update(delta);
        }
        for (Ball ball1 : balls) {
            for (Ball ball2 : balls) {
                if (ball1 != ball2) {
                    ball1.collideWithBall(ball2);
                }
            }
        }

        if (dragged != null) {
            dragged.velocity.scl(0);
            if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
                dragged.radius += Constants.SIZE_RATE * delta;
                ballSize = dragged.radius;
            } else if (Gdx.input.isKeyPressed(Input.Keys.E)) {
                dragged.radius -= Constants.SIZE_RATE * delta;
                ballSize = dragged.radius;
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                balls.remove(dragged);
            }
        }

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Ball ball : balls) {
            ball.draw(renderer);
        }
        if (shooting) {
            Vector2 touchPos = viewport.unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
            renderer.setColor(Color.BLACK);
            renderer.rectLine(dragged.x, dragged.y, touchPos.x, touchPos.y, dragged.radius / 10);
        }
        renderer.end();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
