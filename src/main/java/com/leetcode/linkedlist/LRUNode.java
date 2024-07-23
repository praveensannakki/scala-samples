package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node<K, V> node) {
        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(Node<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    public Node<K, V> removeTail() {
        Node<K, V> res = tail.prev;
        removeNode(res);
        return res;
    }
}

public class LRUNode<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final DoublyLinkedList<K, V> dll;

    public LRUNode(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null; // Key not found
        }
        dll.moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            cache.put(key, newNode);
            dll.addNode(newNode);
            if (cache.size() > capacity) {
                Node<K, V> tail = dll.removeTail();
                cache.remove(tail.key);
            }
        } else {
            node.value = value;
            dll.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUNode<Integer, String> cache = new LRUNode<>(3);

        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");

        System.out.println("Initial cache: ");
        cache.cache.forEach((k, v) -> System.out.println(k + "=" + v.value));

        // Access some elements
        cache.get(1);
        cache.get(2);

        // Add a new element (this will cause the oldest accessed element to be removed)
        cache.put(4, "four");

        System.out.println("Cache after adding 4: ");
        cache.cache.forEach((k, v) -> System.out.println(k + "=" + v.value));

        // Add another new element (this will cause the next oldest accessed element to be removed)
        cache.put(5, "five");

        System.out.println("Cache after adding 5: ");
        cache.cache.forEach((k, v) -> System.out.println(k + "=" + v.value));
    }
}

