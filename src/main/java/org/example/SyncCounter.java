package org.example;

public class SyncCounter {
    private int counter = 0;  // volatile не нужен!

    public synchronized void increment() {
        counter++;
    }

    public int getValue() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncCounter counter = new SyncCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final counter value: " + counter.getValue());  // Всегда 2000
    }
}