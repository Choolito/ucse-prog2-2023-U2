package org.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> generateRandomNumber());
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> generateRandomNumber());
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> generateRandomNumber());
        CompletableFuture<Integer> task4 = CompletableFuture.supplyAsync(() -> generateRandomNumber());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(task1, task2, task3, task4);

        allOf.join();

        int result1 = task1.get();
        int result2 = task2.get();
        int result3 = task3.get();
        int result4 = task4.get();

        int sum = result1 + result2 + result3 + result4;


        System.out.println("Suma de los 4 valores: " + sum);

        try {
            Thread.sleep(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Espera finalizada.");

    }
    private static int generateRandomNumber() {
        return ThreadLocalRandom.current().nextInt(100, 501);
    }
}
