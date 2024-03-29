package com.class18;

public class Rotatematrix {
    // method 1: split into levels and for each level split it into 4 partition
    public void rotate(int[][] matrix) {
        // Assumption: matrix is not null and has size of N*N

        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        int round = n / 2;
        for (int level = 0; level < round; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int i = left; i <= right; i++) {
                int tmp = matrix[left][i];
                matrix[left][i] = matrix[n - 1 -i][left];
                matrix[n - 1 -i][left] = matrix[n - 1 -left][n - 1 -i];
                matrix[n - 1 -left][n - 1 -i] = matrix[i][n - 1 - left];
                matrix[i][n - 1 -left] = tmp;
            }
        }
    }
    

    // method 2: rotate a point by 90 degree clockwise
    // 1. mirror the point according to y axis, then
    // 2. mirror the point according the line of y = x
    public void rotateII(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        mirrorY(matrix, n);
        mirrorEX(matrix, n);
    }

    // mirror the point by y axis
    private void mirrorY(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    // mirror the point by the line of y = x
    private void mirrorEX(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n - 1; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
    }

    private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
        int tmp = matrix[iRow][iCol];
        matrix[iRow][iCol] = matrix[jRow][jCol];
        matrix[jRow][jCol] = tmp;
    }
}
