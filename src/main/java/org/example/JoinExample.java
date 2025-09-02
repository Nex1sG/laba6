package org.example;

public class JoinExample {
    /**
     Метод join(): блокирует выполнение, пока поток, на котором
     вызван метод, не завершится.
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try
        {
            myThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(myThread.getState());
    }
}
