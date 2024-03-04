package com.sortAndArray;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedCities {
    public static int  conClusters(int[][] matInput)
	{
        int rows  = matInput.length;
        int cols = matInput[0].length;
        if (matInput == null || rows == 0 || cols == 0 || rows != cols) {
            return 0;
        }

		int  answer = 0;
        boolean[][] visited = new boolean[rows][cols];
        // bfs on each cities, if it's visited, put in the final list
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    if (matInput[i][j] != 0) {
                        bfs(matInput, i, j, visited);
                    }
                    answer++;
                }
            }
        }
		
		return answer;
	}

    private static void bfs(int[][] matInput, int row, int col, boolean[][] visited) {
        if (visited[row][col] || row < matInput.length || col < matInput[0].length) {
            return;
        }
        Cell start = new Cell(row, col, true);
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            if (!visited[cur.row + 1][col]&& cur.row + 1 < matInput.length && cur.col < matInput[0].length) {
                queue.offer(new Cell(cur.row + 1, cur.col, true));
                visited[cur.row + 1][cur.col] = true;
            }
            if (!visited[row][col + 1] && cur.row < matInput.length && cur.col + 1 < matInput[0].length) {
                queue.offer(new Cell(cur.row, cur.col + 1, true));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        
    }

    static class Cell {
        int row;
        int col;
        boolean visited;

        Cell(int row, int col, boolean visited) {
            this.row = row;
            this.col = col;
            this.visited = visited;
        }
    }
    
}
