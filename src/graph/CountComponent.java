package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountComponent
{
    private int countComponent(int v, int[][] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges)
        {
            adj.get(e[0]).add(1);
            adj.get(e[1]).add(0);
        }

        boolean[] visited = new boolean[v];
        int component = 0;

        for (int i = 0; i < v; i++)
        {
            if (!visited[i])
            {
                component++;
                // BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty())
                {
                    int node = queue.poll();
                    for (int nbr : adj.get(node))
                    {
                        if (!visited[nbr])
                        {
                            visited[nbr] = true;
                            queue.offer(nbr);
                        }
                    }
                }
            }
        }
        return component;
    }
}
