package com.archu.tailrecursion.tailjava;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.math.BigInteger;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException, RunnerException {
//        org.openjdk.jmh.Main.main(args);

        longFactorialTailRec();
        shortFactorialTailRec();

        shortFactorialRec();
        longFactorialRec();
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.Throughput)
    public static void longFactorialTailRec() {
        printf(Factorial.factorialTailRec(BigInteger.valueOf(Short.MAX_VALUE)));
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.Throughput)
    public static void longFactorialRec() {
        try {
            printf(Factorial.factorialRec(BigInteger.valueOf(Short.MAX_VALUE)));
        } catch (StackOverflowError e) {
            System.out.println(e);
        }
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.Throughput)
    public static void shortFactorialRec() {
        try {
            printf(Factorial.factorialRec(BigInteger.TEN));
        } catch (StackOverflowError e) {
            System.out.println(e);
        }
    }

    @Benchmark
    @Fork(value = 1)
    @BenchmarkMode(Mode.Throughput)
    public static void shortFactorialTailRec() {
        printf(Factorial.factorialTailRec(BigInteger.TEN));
    }

    private static void printf(BigInteger number) {
        System.out.printf("%.20s...%n", number);
    }

}
