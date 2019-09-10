package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

class GameScreen extends MainScreen {

    private Bird bird;

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(new InputManager());
        init();
    }

    void init() {
        super.init();
        bird = new Bird(pipes);
    }

    @Override
    public void render(float delta) {
        bird.update(delta);
        camera.position.x = bird.getX() + Constants.WORLD_WIDTH / 4f;
        if (bird.alive) {
            Rectangle rectangle = bird.getBoundingRectangle();
            if (rectangle.overlaps(pipes.nearest.rect1) || rectangle.overlaps(pipes.nearest.rect2)) {
                init();
            }
        } else {
            init();
        }
        super.render(delta);
    }

    @Override
    protected void drawSprites(SpriteBatch batch) {
        bird.draw(batch);
    }
    
    private class InputManager extends InputAdapter {
    	
    	@Override
    	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    		bird.jump();
    		
    		return true;
    	}
    	
    	@Override
    	public boolean keyDown(int keycode) {
    		if (keycode == Input.Keys.SPACE) {
    			bird.jump();
    		}
    		
    		return true;
    	}
    }
}
