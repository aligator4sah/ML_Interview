package com.class13;

public class LargestSubarraySum {
    public int largestSum(int[] array) {
        int cur = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            result = Math.max(result, cur);
        }
        return result;
    }
    
}
