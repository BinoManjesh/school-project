package com.bino.snake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

class Snake extends InputAdapter {

    private ArrayList<SnakePart> parts;
    private Direction direction;
    private float bigDelta;
    private Vector2 prevTouchPos;
    private Viewport viewport;

    Snake(Viewport viewport) {
        init();
        this.viewport = viewport;
    }

    private void init() {
        Gdx.input.setInputProcessor(this);

        parts = new ArrayList<SnakePart>();
        parts.add(new SnakePart(new Vector(1, 1)));

        direction = Direction.RIGHT;
        bigDelta = 0;

        prevTouchPos = new Vector2();
    }

    void draw(ShapeRenderer renderer) {
        renderer.setColor(Constants.Colors.SNAKE_COLOR);
        for (SnakePart part : parts) {
            part.draw(renderer);
        }
    }

    boolean update(float delta, Vector applePos) {
        boolean ateApple = false;
        bigDelta += delta;
        if (bigDelta > Constants.SNAKE_TIME_PERIOD) {
            bigDelta -= Constants.SNAKE_TIME_PERIOD;
            SnakePart firstPart = parts.get(0);

            if (firstPart.position.equals(applePos)) {
                ateApple = true;
                parts.add(new SnakePart(parts.get(parts.size() - 1).position));
            }

            for (int i = parts.size() - 1; i > 0; i--) {
                SnakePart part = parts.get(i);
                if (parts.size() != 2 && firstPart.position.equals(part.position)) {
                    init();
                    return true;
                }
                part.update(parts.get(i - 1));
            }

            switch (direction) {
                case RIGHT:
                    firstPart.position.x += 1;
                    break;
                case LEFT:
                    firstPart.position.x -= 1;
                    break;
                case UP:
                    firstPart.position.y += 1;
                    break;
                case DOWN:
                    firstPart.position.y -= 1;
                    break;
            }

            if (firstPart.position.x > Constants.WORLD_SIZE - 2) {
                firstPart.position.x = 1;
            }
            if (firstPart.position.x < 1) {
                firstPart.position.x = Constants.WORLD_SIZE - 2;
            }
            if (firstPart.position.y > Constants.WORLD_SIZE - 2) {
                firstPart.position.y = 1;
            }
            if (firstPart.position.y < 1) {
                firstPart.position.y = Constants.WORLD_SIZE - 2;
            }
        }
        return ateApple;
    }

    private void changeDirection(Direction direction) {
        switch (direction) {
            case RIGHT:
                if (this.direction != Direction.LEFT) {
                    this.direction = direction;
                }
                break;
            case LEFT:
                if (this.direction != Direction.RIGHT) {
                    this.direction = direction;
                }
                break;
            case UP:
                if (this.direction != Direction.DOWN) {
                    this.direction = direction;
                }
                break;
            case DOWN:
                if (this.direction != Direction.UP) {
                    this.direction = direction;
                }
                break;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.DPAD_RIGHT:
                changeDirection(Direction.RIGHT);
                break;
            case Input.Keys.DPAD_LEFT:
                changeDirection(Direction.LEFT);
                break;
            case Input.Keys.DPAD_UP:
                changeDirection(Direction.UP);
                break;
            case Input.Keys.DPAD_DOWN:
                changeDirection(Direction.DOWN);
                break;
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 thisPos = viewport.unproject(new Vector2(screenX, screenY));
        float x = thisPos.x - prevTouchPos.x;
        float y = thisPos.y - prevTouchPos.y;
        float xAbs = Math.abs(x);
        float yAbs = Math.abs(y);
        if (xAbs > yAbs) {
            if (x > 0) {
                changeDirection(Direction.RIGHT);
            } else if (x < 0) {
                changeDirection(Direction.LEFT);
            }
        } else if (yAbs > xAbs) {
            if (y > 0) {
                changeDirection(Direction.UP);
            } else if (y < 0) {
                changeDirection(Direction.DOWN);
            }
        }

        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("down");
        prevTouchPos = viewport.unproject(new Vector2(screenX, screenY));

        return true;
    }

    private enum Direction {
        RIGHT, LEFT, UP, DOWN
    }
}
