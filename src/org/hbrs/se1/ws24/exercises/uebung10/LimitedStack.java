package org.hbrs.se1.ws24.exercises.uebung10;

import java.util.Stack;

public class LimitedStack<T> extends Stack<T> {
    private final int maxSize;

    public LimitedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public T push(T item) {
        if (this.size() >= maxSize) {
            throw new IllegalStateException("Stack overflow: Maximum size reached");
        }
        return super.push(item);
    }
}
