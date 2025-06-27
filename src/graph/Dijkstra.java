package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra
{
    public static void main(String[] args)
    {
        // Step 1: Define the graph
        Map<String, Map<String, Integer>> graph = new HashMap<>();

        // Example graph
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);

        graph.put("fin", new HashMap<>()); // fin has no neighbors

        // Step 2: Define the costs table
        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE); // infinity

        // Step 3: Define the parents table
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        // Step 4: Keep track of processed nodes
        Set<String> processed = new HashSet<>();

        // Step 5: Dijkstra's main loop
        String node = findLowestCostNode(costs, processed);
        while (node != null)
        {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for (Map.Entry<String, Integer> entry : neighbors.entrySet())
            {
                String neighbor = entry.getKey();
                int newCost = cost + entry.getValue();

                if (costs.getOrDefault(neighbor, Integer.MAX_VALUE) > newCost)
                {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, node);
                }
            }

            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }

        // Step 6: Output the results
        System.out.println("Costs: " + costs);
        System.out.println("Parents: " + parents);

        // Optional: Reconstruct path to fin
        System.out.println("Shortest path to 'fin': " + reconstructPath(parents, "fin"));
    }
    // TC = O(E log V)
    // SC = O(V)

    public static String findLowestCostNode(Map<String, Integer> costs, Set<String> processed)
    {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (Map.Entry<String, Integer> entry : costs.entrySet())
        {
            String node = entry.getKey();
            int cost = entry.getValue();

            if (cost < lowestCost && !processed.contains(node))
            {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }

    public static List<String> reconstructPath(Map<String, String> parents, String target)
    {
        List<String> path = new LinkedList<>();
        String current = target;
        while (current != null)
        {
            path.add(0, current);
            current = parents.get(current);
        }
        return path;
    }
}
