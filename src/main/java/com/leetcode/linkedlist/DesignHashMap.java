package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 706. Design HashMap
 * Design a HashMap without using any built-in hash table libraries.
 *
 * Implement the MyHashMap class:
 *
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 *
 *
 * Constraints:
 *
 * 0 <= key, value <= 106
 * At most 104 calls will be made to put, get, and remove.
 */
class KVPair<K, V> {
    K key;
    V value;

    public KVPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class KVBucket {
    List<KVPair<Integer, Integer>> kvMap;
    public KVBucket() {
        this.kvMap = new LinkedList<KVPair<Integer, Integer>>();
    }

    public Integer getElement(Integer key) {
        for (KVPair<Integer, Integer> kvPair : this.kvMap) {
            if(kvPair.key == key || kvPair.key.equals(key)) {
                return kvPair.value;
            }
        }
        return -1;
    }

    public void addOrUpdateElement(Integer key, Integer value) {
        boolean found = false;
        for (KVPair<Integer, Integer> kvPair : this.kvMap) {
            if (kvPair.key == key || kvPair.key.equals(key)) {
                kvPair.value = value;
                found = true;
            }
        }
        if(!found) {
            this.kvMap.add(new KVPair<Integer, Integer>(key, value));
        }
    }

    public void deleteElement(Integer key) {
        for(KVPair<Integer,Integer> kvPair : this.kvMap) {
            if(kvPair.key == key || kvPair.key.equals(key)) {
                this.kvMap.remove(kvPair);
                break;
            }
        }
    }
}


class DesignHashMap {
    int capacity;
    List<KVBucket> customMap;

    public DesignHashMap() {
        this.capacity = 2069;
        this.customMap = new ArrayList<KVBucket>();
        for (int i =0; i < this.capacity; i++) {
            this.customMap.add(new KVBucket());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % this.capacity;
        this.customMap.get(hashKey).addOrUpdateElement(key,value);
    }

    public int get(int key) {
        int hashKey = key % this.capacity;
        return this.customMap.get(hashKey).getElement(key);
    }

    public void remove(int key) {
        int hashKey = key % this.capacity;
        this.customMap.get(hashKey).deleteElement(key);
    }

    public static void main(String[] args) {
        DesignHashMap designHashMap = new DesignHashMap();
        designHashMap.put(1, 10);
        designHashMap.put(2, 20);
        System.out.println(designHashMap.get(1));
        System.out.println(designHashMap.get(2));
        designHashMap.remove(2);
        System.out.println(designHashMap.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
