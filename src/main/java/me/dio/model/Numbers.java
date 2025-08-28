package me.dio.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Numbers {
    VALUES(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private final List<Integer> nums;

    Numbers(final int... values) {
        this.nums = Arrays.stream(values)
            .boxed()
            .toList();
    }

    public List<Integer> get() {
        Collections.shuffle(nums);

        return nums;
    }
}
