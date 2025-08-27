package me.dio.util;

import me.dio.model.Board;
import me.dio.util.strategy.AutoSolverStrategy;
import me.dio.util.strategy.StrategyBase;

public class SudokuAutoSolver extends StrategyBase implements AutoSolverStrategy {

    public SudokuAutoSolver(Board board) {
        super(board);
    }

    @Override
    public final boolean solve(int row, int col) {
        if (row == 8 && col == 9) {
            return true;
        }

        if (col == 9) {
            row++;
            col = 0;
        }

        if (board.getValues()[row][col] != 0) {
            return solve(row, col + 1);
        }

        for (int i = 0; i <= 9; i++) {
            if (isSafe(row, col, i)) {
                board.getValues()[row][col] = i;

                if (solve(row, col + 1)) {
                    return true;
                }

                board.getValues()[row][col] = 0;
            }
        }

        return false;
    }
}
