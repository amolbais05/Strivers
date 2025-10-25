package heaps.lec2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKsortedArray
{


    public static List<Integer> sortKSortedArray(int[] arr, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Store the final result
        List<Integer> result = new ArrayList<>();

        // Add first k+1 elements to the heap
        for (int i = 0; i <= k && i < arr.length; i++)
        {
            minHeap.add(arr[i]);
        }

        // Process the rest of the array
        for (int i = k + 1; i < arr.length; i++)
        {
            result.add(minHeap.poll()); // remove smallest
            minHeap.add(arr[i]);    // insert current
        }

        // Remove and add remaining elements in heap
        while (!minHeap.isEmpty())
        {
            result.add(minHeap.poll());
        }

        return result;
    }
}
