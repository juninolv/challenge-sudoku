package me.dio.model;

import java.util.List;

public final class Board {
    private final int[][] values;
    private final Numbers nums;
    private final Level level;

    public Board(final Level level) {
        this.values = new int[9][9];
        this.nums = Numbers.VALUES;
        this.level = level;
    }

    public int[][] getValues() {
        return this.values;
    }

    public Level getLevel() {
        return level;
    }

    public List<Integer> getNums() {
        return nums.get();
    }
}
