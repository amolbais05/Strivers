package heaps.lec2;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthSmallest
{
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 20, 4, 15};
        int k = 2;
        System.out.println(findKthSmallest(arr, k));
    }

    // findKthSmallest using properity queue
    public static int findKthSmallest(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
        {
            pq.add(num);
            if (pq.size() > k)
            {
                pq.poll();
            }
        }

        return pq.peek();
    }

}
