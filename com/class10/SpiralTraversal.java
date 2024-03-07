package com.class10;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    // Method 1: Recursive traversal
    public List<Integer> spiral(int[][] matrix) {
        // Assumption: matrix is n * n, N >= 0, matrix is not null
        List<Integer> list = new ArrayList<>();
        recursiveTraverse(matrix, 0, matrix.length, list);
        return list;
    }

    private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
        // base case is when ther is only 0 or 1 element left
        if (size == 0) {
            return;
        }

        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][offset + size - 1]);
        }
        for (int i = size - 1; i >= 0; i--) {
            result.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i >= 0; i--) {
            result.add(matrix[offset + i][offset]);
        }
        recursiveTraverse(matrix, offset + 1, size - 2, result);
    }
    
}
