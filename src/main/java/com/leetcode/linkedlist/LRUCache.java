package com.leetcode.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUNode<Integer, String> cache = new LRUNode<>(3);

        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");

        System.out.println("Initial cache: " + cache);

        // Access some elements
        cache.get(1);
        cache.get(2);

        // Add a new element (this will cause the oldest accessed element to be removed)
        cache.put(4, "four");

        System.out.println("Cache after adding 4: " + cache);

        // Add another new element (this will cause the next oldest accessed element to be removed)
        cache.put(5, "five");

        System.out.println("Cache after adding 5: " + cache);
    }
}

