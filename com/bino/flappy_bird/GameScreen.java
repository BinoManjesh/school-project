package com.bino.flappy_bird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class GameScreen extends ScreenAdapter {

    static final int WIDTH = 200;
    static final int HEIGHT = 300;
    static final float METRE = 100;

    private SpriteBatch batch;
    private Viewport viewport;
    private Camera camera;
    private Bird bird;
    private Pipes pipes;

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new ExtendViewport(WIDTH, HEIGHT);
        camera = viewport.getCamera();
        bird = new Bird(HEIGHT / 2);
        pipes = new Pipes(bird, viewport);
        
        Gdx.input.setInputProcessor(new InputManager());
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        bird.update(delta);
        pipes.update();
        if (bird.getY() <= 0) {
        	bird = new Bird(HEIGHT / 2);
        	pipes = new Pipes(bird, viewport);
        }
        camera.position.x = bird.getX() + viewport.getWorldWidth() / 4f;

        viewport.apply();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        pipes.draw(batch);
        bird.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
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
