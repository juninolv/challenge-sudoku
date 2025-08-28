package me.dio.service;

import me.dio.util.SudokuAutoSolver;
import me.dio.util.SudokuPlayerSolver;
import me.dio.util.strategy.SudokuStrategy;

public class SudokuService {
    private final SudokuStrategy solver;

    public SudokuService(final SudokuStrategy strategy) {
        this.solver = strategy;
    }

    public final void autoSolverHandler() {
        if (solver instanceof SudokuAutoSolver auto) {
            auto.solve(0, 0);
        }
    }

    public final void playerSolverHandler(int row, int col, int value) {
        if (solver instanceof SudokuPlayerSolver player) {
            player.insert(row, col, value);
        }
    }
}
