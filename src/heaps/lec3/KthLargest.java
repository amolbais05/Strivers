package heaps.lec3;

import java.util.PriorityQueue;

public class KthLargest
{
    PriorityQueue<Integer> minHeaps;
    int size;

    public KthLargest(int k, int[] nums)
    {
        minHeaps = new PriorityQueue<>();
        size = k;

        for (int num : nums)
        {
            minHeaps.offer(num);

            if (minHeaps.size() > k)
            {
                minHeaps.poll();
            }
        }
    }

    public int add(int val)
    {
        minHeaps.offer(val);

        if (minHeaps.size() > size)
        {
            minHeaps.poll();
        }
        return minHeaps.peek();
    }

}
