package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraUsingPriorityQueue
{
    private int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        // min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = (int) (1e9);
        }
        // Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;
        pq.add(new Pair(0, src));

        while (!pq.isEmpty())
        {
            Pair pair = pq.poll();
            int distance = pair.distance;
            int node = pair.node;

            for (int i = 0; i < adj.get(node).size(); i++)
            {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (distance + edgeWeight < dist[adjNode])
                {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }

            }
        }
        return dist;

    }

    static class Pair
    {
        int distance;
        int node;

        public Pair(int distance, int node)
        {
            this.distance = distance;
            this.node = node;
        }
    }
}
