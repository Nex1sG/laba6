package org.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class SimpleCache {
    private final ConcurrentHashMap<String,Integer> cache;

    public SimpleCache() {
        cache = new ConcurrentHashMap<>();
    }

    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        cache.put(key, value);
    }
    public Integer computeIfAbsent(String key, Function<String, Integer> loader) {
        return cache.computeIfAbsent(key, loader);
    }
}
