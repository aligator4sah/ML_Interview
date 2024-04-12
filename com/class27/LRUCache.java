package com.class27;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    // each node contains the key, value pair
    // and it is also a double linked list node
    static class Node<K, V> {
        Node<K, V> next;
        Node<K, V> prev;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        void update(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // make it final for the pre-defined size limit of cache
    private final int limit;
    // record all the time the head and tail of the double linked list
    private Node<K, V> head;
    private Node<K, V> tail;

    // maintain the relationship of the key and it's corresponding node in the dll
    private Map<K, Node<K, V>> map;

    public LRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, Node<K, V>>();
    }

    public void set(K key, V value) {
        Node<K, V> node = null;
        // case 1: if the key is already in the cache, we need to update it's value
        // and move it to the head (most recent position)
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if (map.size() < limit) {
            // case 2: if the key is not in the cache and we still have space,
            // we can append a new node to the head
            node = new Node<K, V>(key, value);
        } else {
            // case 3: if the key is not in the cache and we don't have space
            // we need to evict the tail and reuse the node to keep the new key and put it to the head
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        // update the node priority
        remove(node);
        append(node);
        return node.value;
    }


    private Node<K, V> remove(Node<K, V> node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            this.head = head.next;
        }
        if (node == tail) {
            this.tail = tail.prev;
        }
        node.next = node.prev = null;
        return node;
    }

    private Node<K, V> append(Node<K, V> node) {
        map.put(node.key, node);
        if (head == null) {
            this.head = this.tail = node;
        } else {
            node.next = head;
            head.prev = node;
            this.head = node;
        }
        return node;
    }
    
    
}
