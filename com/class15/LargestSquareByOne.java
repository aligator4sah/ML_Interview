package com.class15;

public class LargestSquareByOne {
    public int larget(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int M = matrix.length;
        int N = matrix[0].length;

        int[][] left = new int[M + 1][N + 1];
        int[][] up = new int[M + 1][N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                    for (int maxLength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLength >= 1; maxLength--) {
                        if (left[i + 2 -maxLength][j + 1] >= maxLength && up[i + 1][j + 2 - maxLength] >= maxLength) {
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
}
