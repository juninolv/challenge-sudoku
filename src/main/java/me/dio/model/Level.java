package me.dio.model;

public enum Level {
    EASY(30),
    MIDDLE(45),
    DIFFICULT(55);

    private int value;

    private Level(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }   
}
