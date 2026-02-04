package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland
{
    private int numIsIslands(char[][] grid)
    {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (!visited[i][j] && grid[i][j] == '1')
                {
                    count++;
                    bfs(i, j, visited, grid, n, m);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, boolean[][] visited, char[][] grid, int n, int m)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});

        visited[row][col] = true;

        int[] dRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dCol = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!q.isEmpty())
        {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 8; i++)
            {
                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                if (newRow >= 0 && newRow <= n && newCol >= 0 && newCol <= m && !visited[newRow][newCol] &&
                    grid[newRow][newCol] == '1')
                {
                    visited[newRow][newCol] = true;
                    q.add(new int[] {newRow, newCol});
                }
            }
        }
    }
}