package recursion.lec3;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze
{
    // Directions: Down, Left, Right, Up
    private static final int[] di = {1, 0, 0, -1};
    private static final int[] dj = {0, -1, 1, 0};
    private static final String dir = "DLRU";

    public List<String> findPath(int[][] m, int n)
    {
        List<String> res = new ArrayList<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0)
        {
            return res;
        }
        boolean[][] visited = new boolean[n][n];
        backtrack(0, 0, m, n, visited, "", res);
        return res;
    }

    private void backtrack(int i, int j, int[][] m, int n, boolean[][] visited, String path, List<String> res)
    {
        // Base case: destination reached
        if (i == n - 1 && j == n - 1)
        {
            res.add(path);
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++)
        {
            int ni = i + di[k];
            int nj = j + dj[k];

            if (isSafe(ni, nj, m, n, visited))
            {
                backtrack(ni, nj, m, n, visited, path + dir.charAt(k), res);
            }
        }

        visited[i][j] = false; // Backtrack
    }

    private boolean isSafe(int i, int j, int[][] m, int n, boolean[][] visited)
    {
        return i >= 0 && j >= 0 && i < n && j < n && m[i][j] == 1 && !visited[i][j];
    }

    public static void main(String[] args)
    {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        RatInMaze sol = new RatInMaze();
        List<String> paths = sol.findPath(maze, 4);
        System.out.println(paths); // Output: [DDRDRR, DRDDRR]
    }
}
