package graph;

import java.util.ArrayList;

public class CycleDetectionDirectedDFS
{
    boolean isCycle(int V, int[][] edges)
    {
        var adj = buildAdjDirected(V, edges);
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++)
        {
            if (!visited[i] && dfs(V, adj, visited, inRecursion))
            {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inRecursion)
    {
        visited[u] = true;
        inRecursion[u] = true;

        for (int neighbor : adj.get(u))
        {
            // if not visited, then we check for cycle in DFS
            if (!visited[neighbor] && dfs(neighbor, adj, visited, inRecursion))
            {
                return true;
            }
            else if (inRecursion[neighbor])
            {
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }

    private ArrayList<ArrayList<Integer>> buildAdjDirected(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges)
        {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
        }
        return adj;
    }
}
