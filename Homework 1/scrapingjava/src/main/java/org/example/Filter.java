package org.example;

public interface Filter<T, U> {
    T execute(T input, U extra);
}
