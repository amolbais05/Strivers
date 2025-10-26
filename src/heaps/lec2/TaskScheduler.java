package heaps.lec2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler
{
    public int leastInterval(char[] tasks, int n)
    {
        // Step 1: Count frequency of each task
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks)
        {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Step 2: Create a max heap (priority queue in reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freq.values());

        // Total time required
        int time = 0;

        // Step 3: Process tasks in cycles of size (n + 1)
        while (!maxHeap.isEmpty())
        {

            // Temporary list to store tasks of current cycle
            List<Integer> temp = new ArrayList<>();

            // Set cycle size as cooldown + 1
            int cycle = n + 1;

            // Track number of tasks processed in current cycle
            int i = 0;

            // Run up to (n+1) tasks or until heap is empty
            while (i < cycle && !maxHeap.isEmpty())
            {

                // Pick the most frequent task
                int count = maxHeap.poll();

                // Decrease frequency since task is used once
                count--;

                // If task still remains, store it for next cycle
                if (count > 0)
                {
                    temp.add(count);
                }

                // Count 1 unit time for this task
                time++;
                i++;
            }

            // Step 4: Push remaining tasks from temp back into the heap
            maxHeap.addAll(temp);

            // Step 5: If heap is not empty, add idle time
            if (!maxHeap.isEmpty())
            {
                time += (cycle - i);
            }
        }

        // Return total time taken
        return time;
    }
}
