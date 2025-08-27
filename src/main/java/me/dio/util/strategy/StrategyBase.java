package me.dio.util.strategy;

import java.security.SecureRandom;
import java.util.Collections;

import me.dio.model.Board;

public abstract class StrategyBase {
    protected final Board board;

    protected StrategyBase(Board board) {
        this.board = board;
        this.build();
    }

    private void build() {
        if (fill(0, 0)) {
            leveling();
        }
    }

    protected boolean fill(int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return fill(row + 1, 0);
        }

        Collections.shuffle(board.getNums());

        for (int num : board.getNums()) {
            if (isSafe(row, col, num)) {
                board.getValues()[row][col] = num;

                if (fill(row, col + 1)) {
                    return true;
                }

                board.getValues()[row][col] = 0;
            }
        }

        return false;
    }

    protected void leveling() {
        SecureRandom random = new SecureRandom();
        int cells = board.getLevel().get();

        while (cells > 0) {
            int row = random.nextInt(0, 9);
            int col = random.nextInt(0, 9);

            if (board.getValues()[row][col] != 0) {
                board.getValues()[row][col] = 0;
                cells--;
            }
        }
    }

    protected boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board.getValues()[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board.getValues()[i][col] == num) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getValues()[i + (row - (row % 3))][j + (col - (col % 3))] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
