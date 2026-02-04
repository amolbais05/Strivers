package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        // Form graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
        {
            for (int it : adj.get(i))
            {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (inDegree[i] == 0)
            {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node))
            {
                inDegree[it]--;
                if (inDegree[it] == 0)
                {
                    q.add(it);
                }
            }
        }
        if (topo.size() == numCourses)
        {
            return true;
        }
        return false;
    }
}
