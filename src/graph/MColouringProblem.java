package graph;

import java.util.List;

public class MColouringProblem
{
    public boolean graphColoring(List<Integer>[] G, int i, int m)
    {
        int n = G.length;
        int[] color = new int[n];
        return solve(0, G, color, m);
    }

    public boolean solve(int node, List<Integer>[] G, int[] color, int m)
    {
        if (node == G.length)
        {
            return true;
        }
        for (int i = 1; i <= m; i++)
        {
            if (isSafe(node, G, color, i))
            {
                color[node] = i;
                if (solve(node + 1, G, color, m))
                {
                    return true;
                }
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    public boolean isSafe(int node, List<Integer>[] G, int[] color, int col)
    {
        for (int it : G[node])
        {
            if (color[it] == col)
            {
                return false;
            }
        }
        return true;
    }
    // TC : O (m^n)
    // SC : O (n)
}
