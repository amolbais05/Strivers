package binarysearch.onanswers;

import java.util.stream.IntStream;

public class SmallestDivisorGivenThreshold
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(bruteForce(nums, threshold));
        System.out.println(optimal(nums, threshold));
    }

    private static int bruteForce(int[] nums, int threshold)
    {
        int n = nums.length;
        int max = IntStream.of(nums).max().getAsInt();
        for (int i = 1; i <= max; i++)
        {
            int sum = 0;
            for (int j = 0; j < n; j++)
            {
                sum += Math.ceil((double) nums[j] / i);
            }
            if (sum <= threshold)
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(max(nums) * n)
    // SC : O(1)

    public static int optimal(int[] nums, int threshold)
    {
        int start = 1;
        int end = IntStream.of(nums).max().getAsInt();
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++)
            {
                sum += Math.ceil((double) nums[i] / mid);
            }
            if (sum <= threshold)
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
    // TC : O(log(max(nums)) * n)
    // SC : O(1)
}
