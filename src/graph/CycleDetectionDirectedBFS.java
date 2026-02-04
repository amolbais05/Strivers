package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionDirectedBFS
{
    private boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int indDegree[] = new int[V];

        for (int i = 0; i < V; i++)
        {
            for (int it : adj.get(i))
            {
                indDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
        {
            if (indDegree[i] == 0)
            {
                q.add(i);
            }
        }

        int count = 0;
        int i = 0;
        while (!q.isEmpty())
        {
            int node = q.poll();
            count++;
            // node is in topo sort
            // so remove it from the indegree

            for (int it : adj.get(node))
            {
                indDegree[it]--;
                if (indDegree[it] == 0)
                {
                    q.add(it);
                }
            }
        }
        if (count == V)
        {
            return false;
        }
        return true;
    }

}
