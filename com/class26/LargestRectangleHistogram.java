package com.class26;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleHistogram {
    public int largest(int[] array) {
        int result = 0;
        // record the index in the stack
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.pollFirst()];
                // determine the left boundary of the largest rectangle with height array[i]
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                // determine the right boundary of the largest ractangle with height of the popped element
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }
    
}
