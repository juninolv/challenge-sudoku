package me.dio.util.strategy;

import java.security.SecureRandom;

import me.dio.model.Board;

public abstract class BaseStrategy {
    protected final Board board;

    protected BaseStrategy(final Board value) {
        this.board = value;
        this.build();
    }

    private void build() {
        if (fill(0, 0)) {
            leveling();
        }
    }

    protected final boolean fill(final int row, final int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return fill(row + 1, 0);
        }

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

    protected final void leveling() {
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

    protected final boolean isSafe(
        final int row, final int col, final int num
    ) {
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
                int rowBlock = i + (row - (row % 3));
                int colBlock = j + (col - (col % 3));

                if (board.getValues()[rowBlock][colBlock] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
