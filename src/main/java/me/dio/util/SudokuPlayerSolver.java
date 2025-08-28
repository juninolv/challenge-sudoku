package me.dio.util;

import me.dio.model.Board;
import me.dio.util.strategy.PlayerStrategy;
import me.dio.util.strategy.BaseStrategy;

public class SudokuPlayerSolver extends BaseStrategy implements PlayerStrategy {

    public SudokuPlayerSolver(final Board board) {
        super(board);
    }

    @Override
    public final boolean insert(final int row, final int col, final int num) {
        if (board.getValues()[row][col] != 0) {
            return false;
        }

        if (!isSafe(row, col, num)) {
            return false;
        }

        board.getValues()[row][col] = num;

        return true;
    }
}
