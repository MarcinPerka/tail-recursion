package com.archu.tailrecursion.tailjava;

import java.math.BigInteger;

import static com.archu.tailrecursion.tailjava.BigIntegerUtils.decrement;
import static com.archu.tailrecursion.tailjava.BigIntegerUtils.multiply;
import static com.archu.tailrecursion.tailjava.TailRecImpl.call;
import static com.archu.tailrecursion.tailjava.TailRecImpl.done;

public class Factorial {

    private Factorial() {

    }

    public static BigInteger factorialRec(final BigInteger number) {
        if (number.equals(BigInteger.ONE))
            return number;
        else
            return multiply(number, factorialRec(decrement(number)));
    }

    public static BigInteger factorialTailRec(final BigInteger number) {
        return factorialTailRec(BigInteger.ONE, number).invoke();
    }

    private static TailRec<BigInteger> factorialTailRec(final BigInteger factorial, final BigInteger number) {
        if (number.equals(BigInteger.ONE))
            return done(factorial);
        else
            return call(() -> factorialTailRec(multiply(factorial, number), decrement(number)));
    }
}