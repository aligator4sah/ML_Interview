package com.class27;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValueSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> max = new ArrayList<>();
        // use a descending deque to solve this problem
        // we store the index instead of the actual value int the deque
        // the deque needs to maintain the following features
        // 1. the deque only contains index in the current sliding window
        // 2. for any index, the previous index with smaller value is discarded from the deque
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            // discard any index with smaller value than index i
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            // discard the head element is it's out of the current sliding window scope
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
    
}
