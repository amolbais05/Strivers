package binarysearch.onanswers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AggresiveCows
{
    public static void main(String[] args)
    {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(bruteForce(stalls, k));
      //  System.out.println(optimal(stalls, k));
    }

    private static int bruteForce(int[] stalls, int k)
    {
        int n = stalls.length;
        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= limit; i++)
        {
            if (canWePlace(stalls, i, k))
            {
                return (i - 1);
            }
        }
        return limit;
    }
    // TC : O(n * log(n) + n * limit)
    // SC : O(1)

    private static boolean canWePlace(int[] stalls, int dist, int cows)
    {
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];
        for (int i = 1; i < n; i++)
        {
            if (stalls[i] - last >= dist)
            {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows)
            {
                return true;
            }
        }
        return false;
    }
}
