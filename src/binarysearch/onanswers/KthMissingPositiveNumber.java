package binarysearch.onanswers;

import java.util.stream.IntStream;

public class KthMissingPositiveNumber
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(bruteForce(arr, k));
        System.out.println(optimal(arr, k));
    }

    private static int bruteForce(int[] arr, int k)
    {
        for (int j : arr)
        {
            if (j <= k)
            {
                k++;
            }
            else
            {
                break;
            }
        }
        return k;
    }
    // TC : O(n)
    // SC : 0(1)

    private static int optimal(int[] arr, int k)
    {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }

        }
        return k + end + 1;
    }

}
