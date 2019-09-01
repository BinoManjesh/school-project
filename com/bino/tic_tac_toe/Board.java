package com.bino.tic_tac_toe;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Board {

    private static final String TAG = Board.class.getName();

    Symbol[][] grid;
    State state;

    Board() {
        grid = new Symbol[3][3];
        state = State.ONGOING;
    }

    Board(Board board) {
        grid = new Symbol[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = board.grid[i][j];
            }
        }
        state = board.state;
    }

    boolean makeMove(Symbol symbol, int i, int j) {
        if (grid[i][j] != null) {
            return false;
        }
        grid[i][j] = symbol;
        updateState(symbol);
        return true;
    }

    private void updateState(Symbol symbol) {
        if (isTie()) {
            state = State.TIE;
        }
        if (checkRows(symbol) || checkCols(symbol) || checkDiagonals(symbol)) {
            if (symbol == Symbol.X) {
                state = State.X_WON;
            } else {
                state = State.O_WON;
            }
        }
    }

    private boolean isTie() {
        for (Symbol[] row : grid) {
            for (Symbol symbol : row) {
                if (symbol == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRows(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (checkRow(symbol, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(Symbol symbol, int i) {
        for (int j = 0; j < 3; j++) {
            if (grid[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(Symbol symbol) {
        for (int j = 0; j < 3; j++) {
            if (checkCol(symbol, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(Symbol symbol, int j) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][j] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(Symbol symbol) {
        return checkUpwardDiagonal(symbol) || checkDownwardDiagonal(symbol);
    }

    private boolean checkUpwardDiagonal(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDownwardDiagonal(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][2 - i] != symbol) {
                return false;
            }
        }
        return true;
    }

    void draw(SpriteBatch batch) {
        batch.draw(Assets.instance.grid, 0, 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Symbol symbol = grid[i][j];
                if (symbol != null) {
                    symbol.draw(batch, i * GameScreen.GRID_CELL_SIZE + i + 1, j * GameScreen.GRID_CELL_SIZE + j + 1);
                }
            }
        }
    }

    enum State {
        X_WON, O_WON, TIE, ONGOING
    }
}
