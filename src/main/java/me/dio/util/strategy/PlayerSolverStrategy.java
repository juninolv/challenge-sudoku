package me.dio.util.strategy;

public interface PlayerSolverStrategy extends SudokuStrategy {
    boolean insert(int row, int col, int num);
}
