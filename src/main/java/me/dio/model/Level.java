package me.dio.model;

public enum Level {
    EASY(30),
    MIDDLE(45),
    DIFFICULT(55);

    private final int cells;

    Level(final int value) {
        this.cells = value;
    }

    public int get() {
        return cells;
    }
}
