package com.bino.tic_tac_toe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class GameScreen extends ScreenAdapter {

    private static final int SYMBOL_SIZE = 20;
    static final int GRID_CELL_SIZE = GameScreen.SYMBOL_SIZE + 2;
    private static final int WORLD_SIZE = (SYMBOL_SIZE + 2) * 3 + 2;
    private static final int STATUS_WIDTH = 52;
    private static final int STATUS_HEIGHT = 5;

    private Viewport mainViewport;
    private Viewport statusViewport;
    private SpriteBatch batch;
    private Symbol turn;
    private Board board;
    private Robot robot;

    GameScreen(Symbol symbol) {
        if (symbol != null) {
            robot = new Robot(symbol);
        }
    }

    @Override
    public void show() {
        mainViewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);
        statusViewport = new FitViewport(STATUS_WIDTH, STATUS_HEIGHT);
        batch = new SpriteBatch();

        turn = Symbol.X;
        board = new Board();
        if (robot != null) {
            if (robot.symbol == Symbol.X) {
                int[] move = robot.getMove(board);
                board.makeMove(Symbol.X, move[0], move[1]);
                turn = turn.other();
            }
        }

        Gdx.input.setInputProcessor(new Input());
    }

    @Override
    public void resize(int width, int height) {
        mainViewport.update(width, (int) (height * 0.8f), true);
        statusViewport.update(width, (int) (height * 0.15f), true);
        statusViewport.setScreenY((int) (height * 0.85f));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainViewport.apply();
        batch.setProjectionMatrix(mainViewport.getCamera().combined);

        batch.begin();
        board.draw(batch);
        batch.end();

        statusViewport.apply();
        batch.setProjectionMatrix(statusViewport.getCamera().combined);
        batch.begin();
        if (board.state == Board.State.ONGOING) {
            if (turn == Symbol.X) {
                batch.draw(Assets.instance.xTurn, 0, 0);
            } else {
                batch.draw(Assets.instance.oTurn, 0, 0);
            }
        } else if (board.state == Board.State.X_WON) {
            batch.draw(Assets.instance.xWins, 0, 0);
        } else if (board.state == Board.State.O_WON) {
            batch.draw(Assets.instance.oWins, 0, 0);
        } else {
            batch.draw(Assets.instance.tie, 0, 0);
        }
        batch.end();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private class Input extends InputAdapter {

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            if (board.state != Board.State.ONGOING) {
                TicTacToeGame.game.setScreen(new StartScreen());
            }
            Vector2 touchPos = mainViewport.unproject(new Vector2(screenX, screenY));
            int x = -1;
            int y = -1;

            if (0 <= touchPos.x && touchPos.x < GRID_CELL_SIZE) {
                x = 0;
            } else if (GRID_CELL_SIZE + 1 < touchPos.x && touchPos.x < GRID_CELL_SIZE * 2 + 1) {
                x = 1;
            } else if (GRID_CELL_SIZE * 2 + 2 < touchPos.x && touchPos.x < GRID_CELL_SIZE * 3 + 2) {
                x = 2;
            }

            if (0 <= touchPos.y && touchPos.y < GRID_CELL_SIZE) {
                y = 0;
            } else if (GRID_CELL_SIZE + 1 < touchPos.y && touchPos.y < GRID_CELL_SIZE * 2 + 1) {
                y = 1;
            } else if (GRID_CELL_SIZE * 2 + 2 < touchPos.y && touchPos.y < GRID_CELL_SIZE * 3 + 2) {
                y = 2;
            }
            if (x != -1 && y != -1) {
                if (board.makeMove(turn, x, y)) {
                    turn = turn.other();
                    if (robot != null) {
                        if (board.state == Board.State.ONGOING) {
                            int[] move = robot.getMove(board);
                            board.makeMove(turn, move[0], move[1]);
                            turn = turn.other();
                        }
                    }
                }
            }
            return true;
        }
    }
}
