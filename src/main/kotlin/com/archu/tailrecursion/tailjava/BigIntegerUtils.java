package com.archu.tailrecursion.tailjava;

import java.math.BigInteger;

public class BigIntegerUtils {

    private BigIntegerUtils() {

    }

    public static BigInteger decrement(final BigInteger number) {
        return number.subtract(BigInteger.ONE);
    }

    public static BigInteger multiply(final BigInteger first, final BigInteger second) {
        return first.multiply(second);
    }
}
