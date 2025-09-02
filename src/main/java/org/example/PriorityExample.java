package org.example;

public class PriorityExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread Priority Example: " + Thread.currentThread().getPriority()));
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
