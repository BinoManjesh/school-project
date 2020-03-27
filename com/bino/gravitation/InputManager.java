package com.bino.gravitation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

class InputManager extends InputAdapter {

    private static final int MAX_DISTANCE = 5;

    private MainScreen screen;
    private boolean shouldPan;
    private Vector2 initPos;

    InputManager(MainScreen screen) {
        this.screen = screen;
        shouldPan = true;
        initPos = new Vector2();
    }

    @Override
    public boolean scrolled(int amount) {
        float worldWidth, worldHeight;
        if (amount == 1) {
            worldWidth = screen.viewport.getWorldWidth() * 1.1f;
            worldHeight = screen.viewport.getWorldHeight() * 1.1f;
        } else {
            worldWidth = screen.viewport.getWorldWidth() / 1.1f;
            worldHeight = screen.viewport.getWorldHeight() / 1.1f;
        }
        screen.viewport.setWorldSize(worldWidth, worldHeight);

        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        if (Planet.selected != null) {
            switch (c) {
                case '\b':
                    screen.planets.remove(Planet.selected);
                    Planet.selected = null;
                    break;
                case '+':
                    Planet.selected.scaleRadius(1.1f);
                    break;
                case '-':
                    Planet.selected.scaleRadius(1 / 1.1f);
                    break;
            }
        }

        switch (c) {
            case ' ':
                screen.pause = !screen.pause;
                break;
            case 'a':
                screen.epochs *= 1.1;
                break;
            case 'd':
                screen.epochs /= 1.1;
                break;
            case 13:
                screen.planets.clear();
                break;
        }

        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        initPos.x = screenX;
        initPos.y = screenY;
        Vector2 touchPos = screen.viewport.unproject(new Vector2(screenX, screenY));
        shouldPan = true;
        for (Planet planet : screen.planets) {
            if (planet.contains(touchPos)) {
                shouldPan = false;
                Planet.selected = planet;
                break;
            }
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (shouldPan) {
            float deltaX = -Gdx.input.getDeltaX() * screen.viewport.getWorldWidth() / screen.viewport.getScreenWidth();
            float deltaY = Gdx.input.getDeltaY() * screen.viewport.getWorldHeight() / screen.viewport.getScreenHeight();
            screen.camera.translate(deltaX, deltaY, 0);
        } else if (Planet.selected != null) {
            Vector2 touchPos = screen.viewport.unproject(new Vector2(screenX, screenY));
            if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
                Planet.selected.x = touchPos.x;
                Planet.selected.y = touchPos.y;
            } else if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
                Planet.selected.velocity.x = (Planet.selected.x - touchPos.x) * Planet.velocity_scale;
                Planet.selected.velocity.y = (Planet.selected.y - touchPos.y) * Planet.velocity_scale;
            }
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (shouldPan && Vector2.dst2(screenX, screenY, initPos.x, initPos.y) < MAX_DISTANCE * MAX_DISTANCE) {
            Vector2 touchPos = screen.viewport.unproject(new Vector2(screenX, screenY));
            Planet.selected = new Planet(touchPos);
            screen.planets.add(Planet.selected);
        }

        return true;
    }
}
