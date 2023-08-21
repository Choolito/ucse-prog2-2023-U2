package org.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.CompletableFuture;
public class CompletableFutureExampleTime {
    public static void main(String[] args) {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> generateRandomNumber());
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> generateRandomNumber());
        CompletableFuture<Integer> task3 = CompletableFuture.supplyAsync(() -> generateRandomNumber());
        CompletableFuture<Integer> task4 = CompletableFuture.supplyAsync(() -> generateRandomNumber());

        CompletableFuture<Object> anyTask = CompletableFuture.anyOf(task1, task2, task3, task4);

        anyTask.join();

        int result = 0;
        if (task1.isDone()) {
            result = task1.join();
        } else if (task2.isDone()) {
            result = task2.join();
        } else if (task3.isDone()) {
            result = task3.join();
        } else if (task4.isDone()) {
            result = task4.join();
        }

        System.out.println("Valor de la tarea más rápida: " + result);
    }

    private static int generateRandomNumber() {
        return ThreadLocalRandom.current().nextInt(100, 501);
    }
}
