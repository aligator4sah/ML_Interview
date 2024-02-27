package com.class5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Best First Search, create a minHeap to maintain cell
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val ==  c2.val) {
                    return 0;
                }
                return c1.val < c2.val ? -1 : 1;
            }
        });
        // use a visited matrix to reduce duplication
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        // iterate k - 1 rounds
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            // the neighbor cell will be inserted back to the minheap only if
            /**
             * 1. if it is not out of the boundary
             * 2. it has not been generated before
             */
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.peek().val;
    }

    static class Cell {
        int row;
        int col;
        int val;

        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
}
