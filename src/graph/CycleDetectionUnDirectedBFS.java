package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUnDirectedBFS
{
    boolean isCycle(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();

        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++)
        {
            if (!visited[u] && bfs(u, adj, visited))
            {
                return true;
            }
        }
        return false;
    }

    private boolean bfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(u, -1));
        visited[u] = true;
        while (!queue.isEmpty())
        {
            Pair pair = queue.poll();
            int source = pair.first;
            int parent = pair.second;

            for (int v : adj.get(source))
            {
                if (!visited[v])
                {
                    visited[v] = true;
                    queue.add(new Pair(v, source));
                }
                else if (v != parent)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static class Pair
    {
        int first;
        int second;

        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
}


