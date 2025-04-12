package arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};

        // print array from bruteforce using stream
        System.out.println("Brute Force: " +
            java.util.Arrays.stream(bruteForce(arr1, arr2)).boxed().collect(java.util.stream.Collectors.toList()));

    }

    private static int[] bruteForce(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m)
        {
            if (arr1[i] < arr2[j])
            {
                arr3[k++] = arr1[i++];
            }
            else
            {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n)
        {
            arr3[k++] = arr1[i++];
        }
        while (j < m)
        {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
    // TC : O(n+m)
    // SC : O(n+m)

    private static void better(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        int m = arr2.length;
        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m)
        {
            if (arr1[left] > arr2[right])
            {
                swap(arr1, arr2, left, right);
                left--;
                right++;
            }
            else
            {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    // TC : O(n+m) + O(nlogn) + O(mlogm)
    // SC : O(1)

    private static void swap(int[] arr1, int[] arr2, int index1, int index2)
    {
        int temp = arr1[index1];
        arr1[index1] = arr2[index2];
        arr2[index2] = temp;
    }

    // using gap method
    private static void optimal(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);

        while (gap > 0)
        {
            int left = 0;
            int right = left + gap;
            while (right < len)
            {
                // arr1 and arr2
                if (left < n && right >= n)
                {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // arr2 and arr2
                else if (left >= n)
                {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // arr1 and arr1
                else
                {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
            {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }
    // TC : O(log2(n+m) * (n+m))
    // SC : O(1)

    private static void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2)
    {
        if (arr1[index1] > arr2[index2])
        {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }
}