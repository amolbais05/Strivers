package binarysearch.onanswers;

import java.util.stream.IntStream;

public class MinimumDaysToMakeMbouquets
{
    public static void main(String[] args)
    {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        System.out.println(optimal(bloomDay, m, k));
    }

    public static int optimal(int[] bloomDay, int m, int k) {

        int minDays = -1;
        int start = 0;
        int end = IntStream.of(bloomDay).max().getAsInt();

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (canMakeMBlouq(bloomDay, mid, k) >= m)
            {
                minDays = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return minDays;
    }
    // TC : O(n*log(max(bloomDay)))
    // SC : O(1)

    private static int canMakeMBlouq(int[] bloomDay, int mid, int consequtiveFlower)
    {
        int bouqCount              = 0;
        int consequtiveFlowerCount = 0;

        for (int i = 0; i < bloomDay.length; i++)
        {
            if (bloomDay[i] <= mid)
            {
                consequtiveFlowerCount++;
            }
            else
            {
                consequtiveFlowerCount = 0;
            }

            if (consequtiveFlowerCount == consequtiveFlower)
            {
                bouqCount++;
                consequtiveFlowerCount = 0;
            }

        }
        return bouqCount;

    }
}
