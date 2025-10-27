package heaps.lec3;

import java.util.PriorityQueue;

public class MedianFinder
{
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder()
    {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num)
    {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
        {
            maxHeap.offer(num);
        }
        else
        {
            minHeap.offer(num);
        }

        // Balance the heaps
        if (maxHeap.size() - minHeap.size() > 1)
        {
            minHeap.offer(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size())
        {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian()
    {
        if (maxHeap.size() > minHeap.size())
        {
            return maxHeap.peek();
        }
        else
        {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
