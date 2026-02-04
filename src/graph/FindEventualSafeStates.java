package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates
{
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            revAdj.add(new ArrayList<>());
        }

        int[] outDegree = new int[V];

        // Build reversed graph and outdegree
        for (int u = 0; u < V; u++)
        {
            outDegree[u] = graph[u].length;
            for (int v : graph[u])
            {
                revAdj.get(v).add(u); // reverse edge
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
        {
            if (outDegree[i] == 0)
            {
                q.add(i); // terminal nodes
            }
        }

        boolean[] safe = new boolean[V];

        while (!q.isEmpty())
        {
            int node = q.poll();
            safe[node] = true;

            for (int parent : revAdj.get(node))
            {
                outDegree[parent]--;
                if (outDegree[parent] == 0)
                {
                    q.add(parent);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            if (safe[i])
            {
                ans.add(i);
            }
        }

        return ans;
    }
}
