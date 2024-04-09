package com.class16;

import java.util.Collections;
import java.util.PriorityQueue;

// Median tracker will call read() method to read the values one by one
public class MedianTracker {
    private PriorityQueue<Integer> smallerHalf;
    private PriorityQueue<Integer> largerHalf;

    public MedianTracker() {
        largerHalf = new PriorityQueue<>();
        smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    public void read(int value) {
        // properties need to be maintained
        // size of smaller half == size of larger half when there are even numbers of value read
        // size of smaller half == size of larger half + 1 when there are odd number of values read
        if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
            smallerHalf.offer(value);
        } else {
            largerHalf.offer(value);
        }
        if (smallerHalf.size() - largerHalf.size() >= 2) {
            largerHalf.offer(smallerHalf.poll());
        } else if (largerHalf.size() > smallerHalf.size()) {
            smallerHalf.offer(largerHalf.poll());
        }
    }

    public Double median() {
        int size = size();
        if (size == 0) {
            return null;
        } else if (size % 2 == 0) {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        } else {
            return (double)smallerHalf.peek();
        }
    }

    private int size() {
        return smallerHalf.size() + largerHalf.size();
    }
    
}
