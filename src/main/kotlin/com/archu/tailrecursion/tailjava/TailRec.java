package com.archu.tailrecursion.tailjava;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailRec<T> {
    TailRec<T> apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error("Not implemented");
    }

    default T invoke() {
        return Stream.iterate(this, TailRec::apply)
                .filter(TailRec::isComplete)
                .findFirst()
                .get()
                .result();
    }
}