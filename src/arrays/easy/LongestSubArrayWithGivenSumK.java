package arrays.easy;

import java.util.HashMap;

public class LongestSubArrayWithGivenSumK
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;
        System.out.println(bruteForce(arr, k));
        System.out.println(better(arr, k));
        System.out.println(optimal(arr, k));
    }


    private static int bruteForce(int arr[], int k)
    {
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += arr[j];
                if (sum == k)
                {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }

        }
        return maxLength;
    }
    // TC : O(N^2)
    // SC : O(1)


    private static int better(int arr[], int k)
    {
        // using hashmap
        // This is optimal solution for negative array
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            if (sum == k)
            {
                maxLength = Math.max(maxLength, i + 1);
            }
            int remaining = sum - k;
            if (prefixSum.containsKey(remaining))
            {
                int len = i - prefixSum.get(remaining);
                maxLength = Math.max(maxLength, len);
            }
            if (!prefixSum.containsKey(sum))
            {
                prefixSum.put(sum, i);
            }
        }
        return maxLength;
    }

    private static int optimal(int arr[], int k)
    {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;
        while (right < n)
        {
            sum += arr[right];

            while (left <= right && sum > k)
            {
                sum -= arr[left];
                left++;
            }
            if (sum == k)
            {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right ++;
        }
        return maxLen;
    }
    // TC : O(N)
    // SC : O(1)

}
