package com.class15;

public class LargestSubmatrixSum {
    public int largest(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int[] cur = new int[M];
            for (int j = 0; j < N; j++) {
                add(cur, matrix[j]);
                result = Math.max(result, max(cur));
            }
        }
        return result;
    }

    private void add(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];
        }
    }
    
    // largest subarray sum
    private int max(int[] cur) {
        int result = cur[0];
        int tmp = cur[0];
        for (int i = 1; i < cur.length; i++) {
            tmp = Math.max(tmp + cur[i], cur[i]);
            result = Math.max(result, tmp);
        }
        return result;
    }
    
}
