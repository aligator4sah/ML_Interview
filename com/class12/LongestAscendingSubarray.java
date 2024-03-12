package com.class12;

public class LongestAscendingSubarray {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        /**
         * dp[i] = 1            when array[i] <= array[i-1]
         *       = dp[i] + 1    when array[i] > array[i - 1]
         * using cur recording the last element in dp[i]
         */
        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur++;
                result = Math.max(cur, result);
            } else {
                cur = 1;
            }
        }
        return result;
    }
    
}
