package com.class27;

import java.util.HashMap;
import java.util.HashSet;

public class FirstNonRepeating {
    // each node is a doule linekd list and contains a distinct character
    static class Node {
        Node prev;
        Node next;
        Character ch;

        Node(Character ch) {
            this.ch = ch;
        }
    }

    // record the head and tail of the list all the time
    // only the characters appearing just once will be in the dll
    private Node head;
    private Node tail;
    // for any character, it could be in 3 stats
    /**
     * 1. not existed yet, it will not be in singled Map or repeated set
     * 2. only exists once, it will be in the single map and there will be a corresponding node in the list
     * 3. exists more than once, it will be in the repeated set
     */
    private HashMap<Character, Node> singled;
    private HashSet<Character> repeated;

    public FirstNonRepeating() {
        tail = new Node(null);
        tail.next = tail.prev = tail;
        head = tail;
        singled = new HashMap<>();
        repeated = new HashSet<>();
    }

    public void read(char ch) {
        // ignore the case when the character already exists more than once
        if (repeated.contains(ch)) {
            return;
        }

        Node node = singled.get(ch);
        if (node == null) {
            // the charcter shows up for the first time
            node = new Node(ch);
            append(node);
        } else {
            // if the character is already in the nonRepeated map
            // we should remove it from the map and list
            // and put it into the repeated set
            remove(node);
        }
    }

    private void append(Node node) {
        // append the node to the tail
        singled.put(node.ch, node);
        tail.next = node;
        node.prev = tail;
        node.next = head;
        tail = tail.next;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == tail) {
            tail = node.prev;
        }
        node.prev = node.next = null;
        repeated.add(node.ch);
        singled.remove(node.ch);
    }

    public Character firstNonRepeating() {
        if (head == tail) {
            return null;
        }
        return head.next.ch;
    }
    
    
}
