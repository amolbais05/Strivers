package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MangoSellerSearch
{
    private static HashMap<String, List<String>> graph = new HashMap<>();

    private static boolean isMangoSeller(String name)
    {
        return name.endsWith("m");
    }

    private static boolean search(String name)
    {
        Set<String> visited = new HashSet<>();
        Queue<String> searchQueue = new LinkedList<>();
        searchQueue.addAll(graph.getOrDefault(name, Collections.emptyList()));

        while (!searchQueue.isEmpty())
        {
            String person = searchQueue.poll();
            if (!visited.contains(person))
            {
                if (isMangoSeller(person))
                {
                    System.out.println(person + " is a mango seller!");
                    return true;
                }
                else
                {
                    visited.add(person);
                    searchQueue.addAll(graph.getOrDefault(person, Collections.emptyList()));
                }
            }
        }
        return false;
    }
    // TC = O(V+E)
    // SC = O(V)

    public static void main(String[] args)
    {
        graph.put("you", List.of("alice", "bob", "claire"));
        graph.put("bob", List.of("anuj", "peggy"));
        graph.put("alice", List.of("peggy"));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        search("you");
    }
}
