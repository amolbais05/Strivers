package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEfforts
{
    public int minimumEffortPath(int[][] heights)
    {

        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                dist[i][j] = (int) (1e9);
            }
        }
        dist[0][0] = 0; // source
        pq.add(new Tuple(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (pq.size() != 0)
        {
            Tuple it = pq.poll();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if (row == n - 1 && col == m - 1)
            {
                return diff;
            }

            for (int i = 0; i < 4; i++)
            {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m)
                {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);
                    if (newEffort < dist[newRow][newCol])
                    {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new Tuple(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }

    public static class Tuple
    {
        int distance;
        int row;
        int col;

        public Tuple(int distance, int row, int col)
        {
            this.distance = distance;
            this.row = row;
            this.col = col;

        }
    }
}
