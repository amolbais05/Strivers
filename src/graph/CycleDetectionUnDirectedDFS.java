package graph;

import java.util.ArrayList;

public class CycleDetectionUnDirectedDFS
{

    boolean isCycle(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();

        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++)
        {
            if (!visited[u] && dfs(u, adj, visited, -1))
            {
                return true;
            }

        }

        return false;
    }

    private boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent)
    {
        visited[V] = true;

        for (int neighbor : adj.get(V))
        {
            if (parent == neighbor)
            {
                continue;
            }
            if (visited[neighbor])
            {
                return true;
            }
            if (dfs(neighbor, adj, visited, V))
            {
                return true;
            }
        }
        return false;
    }

}
