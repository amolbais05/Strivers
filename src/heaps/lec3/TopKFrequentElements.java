package heaps.lec3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements
{
    public int[] topKFrequent(int[] nums, int k)
    {
        // Create a frequency map to count the occurrences of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Create a min heap to store the top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        for (int num : freqMap.keySet())
        {
            minHeap.offer(num);
            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--)
        {
            result[i] = minHeap.poll();
        }
        return result;
    }
    // TC: O(n log k)
    // SC: O(n)

}
