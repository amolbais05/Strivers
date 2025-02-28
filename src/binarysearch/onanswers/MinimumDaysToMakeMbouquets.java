package binarysearch.onanswers;

public class MinimumDaysToMakeMbouquets
{
    public static void main(String[] args)
    {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(bruteForce(bloomDay, m, k));
        System.out.println(optimal(bloomDay, m, k));
    }

    private static int bruteForce(int[] bloomDay, int m, int k)
    {
        int n = bloomDay.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            max = Math.max(max, bloomDay[i]);
        }
        int low = 0;
        int high = max;
        int ans = -1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, m, k, mid))
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    // TC : O(n*log(max(bloomDay)))
    // SC : O(1)
    private static boolean isPossible(int[] bloomDay, int m, int k, int mid)
    {
        int n = bloomDay.length;
        int count = 0;
        int numberOfBouquets = 0;
        for (int i = 0; i < n; i++)
        {
            if (bloomDay[i] <= mid)
            {
                count++;
            }
            else
            {
                numberOfBouquets += count / k;
                count = 0;
            }
        }
        numberOfBouquets += count / k;
        return numberOfBouquets >= m;
    }
}
