package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LazyRace {

    public class LazyCache {
        private Map<String, String> cache = new ConcurrentHashMap<>();

        public String getValue(String key) {
            return cache.computeIfAbsent(key, this::expensiveDatabaseCall);
        }

        private String expensiveDatabaseCall(String key) {
            return key.toUpperCase() + "_PROCESSED";
        }
    }
}
