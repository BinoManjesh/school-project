package com.bino.particle_simulator;

import com.badlogic.gdx.Game;

public class ParticleSimulatorGame extends Game {

    @Override
    public void create() {
        setScreen(new MainScreen());
    }
}
