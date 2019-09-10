package com.bino.flappy_bird;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Launcher {

    public static void main(String[] args) {
        new LwjglApplication(new FlappyBirdGame());
    }
}
