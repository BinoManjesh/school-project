package com.bino.flappy_bird.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Assets {

    private static final int BUTTON_SIZE = 32;

    public static Texture bird;

    public static Sprite play;
    public static Rectangle playBounds;

    public static Sprite evolve;
    public static Rectangle evolveBounds;

    public static NinePatch pipe;

    public static BitmapFont font;

    public static void init() {
        bird = new Texture(Gdx.files.internal("assets/flappy_bird/bird.png"));

        play = new Sprite(new Texture(Gdx.files.internal("assets/flappy_bird/play.png")));
        playBounds = play.getBoundingRectangle();

        evolve = new Sprite(new Texture(Gdx.files.internal("assets/flappy_bird/evolve.png")));
        evolve.setX(BUTTON_SIZE * 2);
        evolveBounds = evolve.getBoundingRectangle();

        Texture pipeTexture = new Texture(Gdx.files.internal("assets/flappy_bird/pipe.png"));
        pipe = new NinePatch(pipeTexture, 0, 0, GlobalConstants.PIPE_EDGE, GlobalConstants.PIPE_EDGE);

        font = new BitmapFont(Gdx.files.internal("assets/flappy_bird/pixel-font.fnt"));
    }
}
