package com.asherbakov.hwAnother;

import java.util.Objects;
import java.util.Random;

public class Task {
    private final int MIN_VALUE = 2;
    private final int MAX_VALUE = 9;
    private int firstNum;
    private int secondNum;

    public Task() {
        Random random = new Random();
        firstNum = (random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
        secondNum = (random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        boolean flag = false;
        return (firstNum == task.firstNum &&
                secondNum == task.secondNum) ||
                (firstNum == task.secondNum &&
                secondNum == task.firstNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNum, secondNum);
    }

    @Override
    public String toString() {
        return firstNum + " * " + secondNum + " = ";
    }
}
