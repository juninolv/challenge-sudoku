package me.dio.model;

import java.util.Arrays;
import java.util.List;

public class Board {
    private final int[][] values;
    private final List<Integer> nums;
    private final Level level;
    
    public Board(Level level) {
        this.values = new int[9][9];
        this.nums = Arrays.asList(1, 2, 3, 4, 3, 5, 6, 7, 8, 9);
        this.level = level;
    }

    public int[][] getValues() {
        return this.values;
    }

    public Level getLevel() {
        return level;
    }

    public List<Integer> getNums() {
        return nums;
    }
}
