package org.example;

public class SyncSingleton {

    private static volatile SyncSingleton instance;
    // Обязательно volatile
    public static SyncSingleton getInstance() {
        // first check
        if (instance == null) {
            synchronized (SyncSingleton.class) {
                // second check
                if (instance == null) {
                    instance = new SyncSingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * public class SyncSingleton {
 *     private SyncSingleton() {}
 *
 *     private static class Holder {
 *         static final SyncSingleton INSTANCE = new SyncSingleton();
 *     }
 *
 *     public static SyncSingleton getInstance() {
 *         return Holder.INSTANCE;
 *     }
 * }
 */
