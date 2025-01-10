package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence
{
    public static void main(String[] args)
    {
        int[] arr = {100, 200, 1, 2, 3, 4};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[] arr)
    {
        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++)
        {
            int num = arr[i];
            int count = 1;
            while (linearSearch(arr, num + 1))
            {
                num++;
                count++;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
    /// TC : O(N^3)
    // SC : O(1)

    private static int better(int[] arr)
    {
        int n = arr.length;
        Arrays.sort(arr);
        int longest = 1;
        int currentCount = 0;
        int lastSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
        {
            if (arr[i] - 1 == lastSmaller)
            {
                currentCount++;
                longest++;
                lastSmaller = arr[i];
            }
            if (arr[i] != lastSmaller)
            {
                currentCount = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, currentCount);

        }
        return longest;
    }
    // TC : O(NlogN)
    // SC : O(1)

    private static int optimal(int[] arr)
    {
        int n = arr.length;
        if (n == 0)
        {
          return 0;
        }

        int longest = 1;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : arr)
        {
            hashSet.add(num);
        }

        for (int num : hashSet)
        {
            if (!hashSet.contains(num - 1))
            {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1))
                {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
    // TC : O(N)
    // SC : O(N)


    private static boolean linearSearch(int[] arr, int target)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == target)
            {
                return true;
            }
        }
        return false;
    }
}
