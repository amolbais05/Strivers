package graph;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch
{
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    private void bfs(int start)
    {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start); // enqueue the starting node
        visited.add(start); // mark the starting node as visited

        while (!queue.isEmpty())
        {
            int node = queue.poll(); // dequeue the next node

            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList()))
            {
                if (!visited.contains(neighbor))
                {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
