package heaps.lec3;

import java.util.PriorityQueue;

public class ConnectNRopesMinimumCost
{
    public static int connectNRopes(int[] arr)
    {
        // Create a priority queue (min-heap) to store the ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add all ropes to the priority queue
        for (int rope : arr)
        {
            pq.add(rope);
        }
        int cost = 0;
        // Connect ropes until only one rope is left in the priority queue
        while (pq.size() > 1)
        {
            // Extract the two smallest ropes from the priority queue
            int first = pq.poll();
            int second = pq.poll();
            // Calculate the cost of connecting the two ropes
            int newRope = first + second;
            // Add the cost to the total cost
            cost += newRope;
            // Add the new rope to the priority queue
            pq.add(newRope);
        }
        return cost;
    }
    // TC : O (n log n)
    // SC : O (n)


}
