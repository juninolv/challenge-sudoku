package me.dio.util.strategy;

public interface AutoSolverStrategy extends SudokuStrategy {
    boolean solve(int row, int col);
}
