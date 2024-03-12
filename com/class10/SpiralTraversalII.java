package com.class10;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalII {
    public List<Integer> spiral(int[][] matrix) {
        // Assumption: matrix is not null, has size of M * N
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        // base case:
        // 1. nothing left; 2. one row left; 3. one column left
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        // if there is noting left
        if (left > right || up > down) {
            return list;
        }
        // if there is one column left
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        } else {
            // if there is one row left
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
        }
        
        return list;
    }
    
}
