package me.dio.util.strategy;

public interface AutoStrategy extends SudokuStrategy {
    boolean solve(int row, int col);
}
