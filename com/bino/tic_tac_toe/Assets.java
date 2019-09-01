package com.bino.tic_tac_toe;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class Assets {

    static Assets instance = new Assets();

    TextureRegion humanVHuman;
    TextureRegion humanVBot;
    TextureRegion x;
    TextureRegion o;
    TextureRegion grid;
    TextureRegion xTurn;
    TextureRegion oTurn;
    TextureRegion xWins;
    TextureRegion oWins;
    TextureRegion tie;

    private Assets() {}

    void init() {
        TextureAtlas atlas = new TextureAtlas("assets/tic_tac_toe/textures.pack.atlas");
        humanVHuman = atlas.findRegion("human-v-human");
        humanVBot = atlas.findRegion("human-v-bot");
        x = atlas.findRegion("x");
        o = atlas.findRegion("o");
        grid = atlas.findRegion("grid");
        xTurn = atlas.findRegion("x's-turn");
        oTurn = atlas.findRegion("o's-turn");
        xWins = atlas.findRegion("x-wins");
        oWins = atlas.findRegion("o-wins");
        tie = atlas.findRegion("tie");
    }
}
