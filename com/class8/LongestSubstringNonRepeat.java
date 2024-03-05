package com.class8;

import java.util.HashSet;
import java.util.Set;


public class LongestSubstringNonRepeat {
    public int longest(String input) {
        // the distinct set contains all distinct characters in the sliding window
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;

        while (fast < input.length()) {
            if (distinct.contains(input.charAt(fast))) {
                distinct.remove(input.charAt(slow++));
            } else {
                distinct.add(input.charAt(fast++));
                longest = Math.max(fast - slow, longest);
            }
        }

        return longest;
    }
    
}
