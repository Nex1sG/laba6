package org.example;

public class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread is running");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= 3; i++){
            System.out.println(i);
            Thread.yield();
        }

        System.out.println("Thread woke up after 3 seconds");

    }
}