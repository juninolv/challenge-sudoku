package me.dio.util.strategy;

public interface PlayerStrategy extends SudokuStrategy {
    boolean insert(int row, int col, int num);
}
