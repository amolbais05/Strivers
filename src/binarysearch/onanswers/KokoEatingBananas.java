package binarysearch.onanswers;

import java.util.stream.IntStream;

public class KokoEatingBananas
{
    public static void main(String[] args)
    {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(bruteForce(piles, h));
        System.out.println(optimal(piles, h));
    }

    private static int bruteForce(int[] piles, int h)
    {
        int n = piles.length;
        int max = IntStream.of(piles).max().getAsInt();
        for (int i = 1; i <= max; i++)
        {
            int hours = 0;
            for (int j = 0; j < n; j++)
            {
                hours += Math.ceil((double) piles[j] / i);
            }
            if (hours <= h)
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(max(piles) * n)
    // SC : O(1)

    public int optimal(int[] piles, int h) {

        int start = 1;
        int end = 1000000000;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            int hours = calculateTotalHour(piles, mid);
            if (hours <= h)
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
    // TC : O(log(max(piles)) * n)
    // SC : O(1)

    private int calculateTotalHour(int[] piles, int hour)
    {
        int totalHour = 0;
        for (int pile : piles)
        {
            totalHour += (pile + hour - 1) / hour; // Optimized division
        }
        return totalHour;
    }

}
