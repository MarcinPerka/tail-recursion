package com.archu.tailrecursion.tailjava;

public class TailRecImpl {

    private TailRecImpl() {

    }

    public static <T> TailRec<T> call(final TailRec<T> nextCall) {
        return nextCall;
    }

    public static <T> TailRec<T> done(final T value) {
        return new TailRec<T>() {
            @Override
            public boolean isComplete() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }

            @Override
            public TailRec<T> apply() {
                throw new Error("Not implemented");
            }
        };
    }
}