package com.bino.tic_tac_toe;

import java.util.ArrayList;

class Robot {

    private static final int X_VALUE = 1;
    private static final int O_VALUE = -1;

    Symbol symbol;

    Robot(Symbol symbol) {
        this.symbol = symbol;
    }

    int[] getMove(Board board) {
        Integer[] move = minimax(board, symbol);
        return new int[]{move[1], move[2]};
    }

    private Integer[] minimax(Board board, Symbol symbol) {
        if (board.state != Board.State.ONGOING) {
            if (board.state == Board.State.X_WON) {
                return new Integer[]{X_VALUE};
            } else if (board.state == Board.State.O_WON) {
                return new Integer[]{O_VALUE};
            } else {
                return new Integer[]{0};
            }
        }
        ArrayList<Integer[]> moves = getMoves(board);
        Integer[] bestMove = null;
        Symbol other = symbol.other();
        int bestVal;
        if (symbol == Symbol.X) {
            bestVal = -2;
        } else {
            bestVal = 2;
        }
        for (Integer[] move : moves) {
            Board copy = new Board(board);
            copy.makeMove(symbol, move[0], move[1]);
            int value = minimax(copy, other)[0];
            if (symbol == Symbol.X) {
                if (value > bestVal) {
                    bestVal = value;
                    bestMove = move;
                }
            } else {
                if (value < bestVal) {
                    bestVal = value;
                    bestMove = move;
                }
            }
        }
        return new Integer[]{bestVal, bestMove[0], bestMove[1]};
    }

    private ArrayList<Integer[]> getMoves(Board board) {
        ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.grid[i][j] == null) {
                    moves.add(new Integer[]{i, j});
                }
            }
        }
        return moves;
    }
}
