package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DijkstraUsingSet
{
    // set erase use logN time , iteration is fine with it
    private int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        // TreeSet acts like ordered set (min distance first)
        TreeSet<Pair> set = new TreeSet<>();

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;
        set.add(new Pair(0, src));

        while (!set.isEmpty())
        {
            Pair pair = set.pollFirst();
            int distance = pair.distance;
            int node = pair.node;

            for (int i = 0; i < adj.get(node).size(); i++)
            {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (distance + edgeWeight < dist[adjNode])
                {
                    dist[adjNode] = distance + edgeWeight;
                    set.add(new Pair(dist[adjNode], adjNode));
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
