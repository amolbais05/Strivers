package graph;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch
{
    private void dfs(
        int v,
        Map<Integer, List<Integer>> adj,
        Set<Integer> visited,
        List<Integer> result
    )
    {
        if (!visited.add(v))
        {
            return;     // add() returns false if already present
        }
        result.add(v);

        for (int nei : adj.getOrDefault(v, Collections.emptyList()))
        {
            if (!visited.contains(nei))
            {
                dfs(nei, adj, visited, result);
            }
        }
    }

}
