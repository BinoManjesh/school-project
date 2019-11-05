package com.bino.gravitation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

class InputManager extends InputAdapter {

    private static final int SIZE_SPEED = 10;
    private static final int EPOCH_SPEED = 1000;
    private static final int INIT_EPOCHS = 2000;
    private static final float VELOCITY_COEFFICIENT = 0.001f;

    float epochs;

    private Viewport viewport;
    private Camera camera;
    private Satellite satellite;

    private float widthRatio;
    private float heightRatio;

    private boolean isDragging;
    private Vector2 touchPos;

    InputManager(Viewport viewport, Camera camera, Satellite satellite) {
        this.viewport = viewport;
        this.camera = camera;
        this.satellite = satellite;

        widthRatio = viewport.getWorldWidth() / viewport.getScreenWidth();
        heightRatio = viewport.getWorldHeight() / viewport.getScreenHeight();

        epochs = INIT_EPOCHS;
    }

    void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            epochs += delta * EPOCH_SPEED;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            epochs -= delta * EPOCH_SPEED;
        }
    }

    void draw(ShapeRenderer renderer) {
        if (isDragging) {
            renderer.line(satellite.position, touchPos);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!satellite.alive) {
            touchPos = viewport.unproject(new Vector2(screenX, screenY));
            if (isInSatellite(touchPos)) {
                isDragging = true;
                System.out.println("isDragging = " + true);
            } else {
                satellite.position = touchPos;
            }
        }

        return true;
    }

    private boolean isInSatellite(Vector2 touchPos) {
        return (touchPos.x > (satellite.position.x - Satellite.RADIUS) &&
                touchPos.x < (satellite.position.x + Satellite.RADIUS)) &&
                (touchPos.y > (satellite.position.y - Satellite.RADIUS) &&
                        touchPos.y < (satellite.position.y + Satellite.RADIUS));
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (!isDragging) {
            System.out.println("Panning");
            camera.translate(-Gdx.input.getDeltaX() * widthRatio, Gdx.input.getDeltaY() * heightRatio, 0);
        } else {
            touchPos = viewport.unproject(new Vector2(screenX, screenY));
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (isDragging) {
            satellite.alive = true;
            satellite.velocity =
                    viewport.unproject(new Vector2(screenX, screenY)).sub(satellite.position).scl(VELOCITY_COEFFICIENT);
            System.out.println(satellite.velocity);
            satellite.velocity.scl(-1);
            isDragging = false;
        }

        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE) {
            satellite.init();
        }

        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        resize();
        float worldHeight = viewport.getWorldHeight();
        float worldWidth = viewport.getWorldWidth();

        worldWidth += SIZE_SPEED * amount;
        worldHeight += SIZE_SPEED * amount;

        viewport.setWorldSize((worldWidth < 1) ? 1 : worldWidth, (worldHeight < 1) ? 1 : worldHeight);

        return true;
    }

    void resize() {
        widthRatio = viewport.getWorldWidth() / viewport.getScreenWidth();
        heightRatio = viewport.getWorldHeight() / viewport.getScreenHeight();
    }
}
