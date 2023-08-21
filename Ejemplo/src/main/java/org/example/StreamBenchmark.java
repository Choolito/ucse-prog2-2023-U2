package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 1)
public class StreamBenchmark {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
    @State(Scope.Thread)
    public static class BenchmarkState{
        List<Integer> list;

        @Setup(Level.Trial)
        public void setup(){
            int size = 10000000;
            Random random = new Random();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(random.nextInt(1, 50000));
            }
        }
    }
    @Benchmark
    public List<Integer> resultSecuencial(BenchmarkState state) {
        return state.list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
    @Benchmark
    public List<Integer> resultParalelo(BenchmarkState state) {
        return state.list.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}
