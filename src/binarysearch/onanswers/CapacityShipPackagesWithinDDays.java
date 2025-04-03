package binarysearch.onanswers;

import java.util.stream.IntStream;

public class CapacityShipPackagesWithinDDays
{
    public static void main(String[] args)

    {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int days = 5;
        System.out.println(bruteForce(weights, days));
        System.out.println(optimal(weights, days));
    }

    private static int bruteForce(int[] weights, int days)
    {
        int n = weights.length;
        int max = IntStream.of(weights).max().getAsInt();
        int sum = IntStream.of(weights).sum();

        for (int i = max; i <= sum; i++)
        {
            if (findDays(weights, i) <= days)
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(max(weights) * n)
    // SC : O(1)

    private static int findDays(int[] weights, int cap)
    {
        int n = weights.length;
        int days = 1;
        int load = 0;
        for (int i = 0; i < n; i++)
        {
            if (load + weights[i] > cap)
            {
                days++;
                load = weights[i];
            }
            else
            {
                load += weights[i];
            }
        }
        return days;
    }

    public static int optimal(int[] weights, int days)
    {
        int start = IntStream.of(weights).max().getAsInt();
        int end = IntStream.of(weights).sum();
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (findDays(weights, mid) <= days)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start;
    }
    // TC : O(n*log(sum(weights)))
    // SC : O(1)


}
