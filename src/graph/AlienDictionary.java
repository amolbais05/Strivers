package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary
{
    private List<Integer> topoSort(int V, List<List<Integer>> adj)
    {
        // Array to keep track of indegree (number of incoming edges) of each node
        int[] indegree = new int[V];

        // Calculate indegree for each vertex
        for (int i = 0; i < V; i++)
        {
            for (int neighbor : adj.get(i))
            {
                indegree[neighbor]++;
            }
        }

        // Queue to store nodes with indegree = 0 (i.e., nodes that can be processed first)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
        {
            if (indegree[i] == 0)
            {
                q.add(i);
            }
        }

        // List to store topological order
        List<Integer> topo = new ArrayList<>();

        // Process the queue
        while (!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node); // Add node to result

            // Decrease indegree of its neighbors
            for (int neighbor : adj.get(node))
            {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                {
                    q.add(neighbor);
                }
            }
        }

        return topo;
    }

    private String findOrder(String[] dict, int N, int K)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++)
        {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++)
            {
                if (s1.charAt(ptr) != s1.charAt(ptr))
                {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for (int it : topo)
        {
            ans = ans + (char) (it + (int) 'a');
        }
        return ans;
    }
}
