package binarysearch.onedimensionarray;

import java.util.HashMap;
import java.util.Map;

public class SearchSingleElementInSorted
{
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(bruteForce(arr));
        System.out.println(bruteForce2(arr));
        System.out.println(optimal(arr));
        System.out.println(optimalBinarySearch(arr));
    }

    private static int bruteForce(int[] nums)
    {
        int n = nums.length;

        if (n == 1)
        {
            return nums[0];
        }

        for (int i = 0; i < n; i++)
        {
            if (i == 0) // first element
            {
                if (nums[i] != nums[i + 1])
                {
                    return nums[i];
                }
            }
            else if (i == n - 1) // last element
            {
                if (nums[i] != nums[i - 1])
                {
                    return nums[i];
                }
            }
            else // middle element
            {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                {
                    return nums[i];
                }
            }
        }
        return -1;
    }
    // TC : O(n)
    // SC : O(1)

    private static int bruteForce2(int[] nums)
    {
        if (nums.length == 1)
        {
            return nums[0];
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
        {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.entrySet()
            .stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(-1);
    }
    // TC : O(n)
    // SC : O(n) Because of HashMap

    private static int optimal(int[] nums)
    {
        int num = 0;
        for (int j : nums)
        {
            num ^= j;
        }
        return num;
    }
    // TC : O(n)
    // SC : O(1)

    private static int optimalBinarySearch(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;

        while (start < end)
        {
            int mid = start + (end - start) / 2;

            // Ensure mid is even to compare with mid + 1
            if (mid % 2 == 1)
            {
                mid--;
            }

            // If nums[mid] == nums[mid + 1], move right
            if (nums[mid] == nums[mid + 1])
            {
                start = mid + 2;
            }
            else
            {
                end = mid;
            }
        }

        return nums[start];
    }
    // TC : O(log n)
    // SC : O(1)


}
