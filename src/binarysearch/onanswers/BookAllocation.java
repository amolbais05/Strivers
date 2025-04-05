package binarysearch.onanswers;

import java.util.stream.IntStream;

public class BookAllocation
{
    public static void main(String[] args)
    {
        int[] arr = {12, 34, 67, 90};
        int m = 2;
        System.out.println(bruteForce(arr, m));
        System.out.println(optimal(arr, m));
    }

    private static int bruteForce(int[] arr, int m)
    {
        int n = arr.length;
        if (m > n)
        {
            return -1;
        }
        int low = IntStream.of(arr).max().getAsInt();
        int high = IntStream.of(arr).sum();

        for (int pages = low; pages <= high; pages++)
        {
            if (isPossible(arr, m, pages))
            {
                return pages;
            }
        }
        return -1;
    }
    // TC : O(N * (sum(arr[])-max(arr[])+1))
    // SC : O(1)

    private static boolean isPossible(int[] arr, int m, int pages)
    {
        int n = arr.length;
        int students = 1;
        int sumAllocated = 0;
        for (int i = 0; i < n; i++)
        {
            if (sumAllocated + arr[i] > pages)
            {
                students++;
                sumAllocated = arr[i];
            }
            else
            {
                sumAllocated += arr[i];
            }
        }
        return students <= m;
    }

    private static int optimal(int[] arr, int m)
    {
        int n = arr.length;
        if (m > n)
        {
            return -1;
        }
        int low = IntStream.of(arr).max().getAsInt();
        int high = IntStream.of(arr).sum();

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, m, mid))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
    // TC : O(N * log(sum(arr[])-max(arr[])+1))
    // SC : O(1)

}
