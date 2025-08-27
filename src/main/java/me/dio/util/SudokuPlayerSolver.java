package me.dio.util;

import me.dio.model.Board;
import me.dio.util.strategy.PlayerSolverStrategy;
import me.dio.util.strategy.StrategyBase;

public class SudokuPlayerSolver extends StrategyBase implements PlayerSolverStrategy {
    
    public SudokuPlayerSolver(Board board) {
        super(board);
    }

    @Override
    public boolean insert(int row, int col, int num) {
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
