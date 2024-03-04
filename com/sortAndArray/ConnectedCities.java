package com.sortAndArray;

public class ConnectedCities {
    public static int  conClusters(int[][] matInput)
	{
        int rows  = matInput.length;
        int cols = matInput[0].length;
        if (matInput == null || rows == 0 || cols == 0 || rows != cols) {
            return 0;
        }

		int  answer = 0;
        // bfs on each cities, if it's visited, put in the final list
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matInput[i][j] != 0) {
                    Cell start = new Cell(i, j, true);
                }
            }
        }
		
		
		return answer;
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
