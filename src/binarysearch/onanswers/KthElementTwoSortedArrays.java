package binarysearch.onanswers;

import java.util.ArrayList;

public class KthElementTwoSortedArrays
{
    public static void main(String[] args)
    {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(bruteForce(arr1, arr2, k));
        System.out.println(better(arr1, arr2, k));
        //System.out.println(kthElement(arr1, arr2, k));
    }

    private static int bruteForce(int[] arr1, int[] arr2, int k)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr3 = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k1 = 0;
        int count = 0;
        while (i < n1 && j < n2)
        {
            if (arr1[i] < arr2[j])
            {
                arr3[k1++] = arr1[i++];
            }
            else
            {
                arr3[k1++] = arr2[j++];
            }
        }
        while (i < n1)
        {
            arr3[k1++] = arr1[i++];
        }
        while (j < n2)
        {
            arr3[k1++] = arr2[j++];
        }
        return arr3[k - 1];
    }
    // TC ; O(n1+n2)
    // SC : O(n1+n2)

    private static int better(int[] arr1, int[] arr2, int k)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int count = 0;
        int i = 0;
        int j = 0;
        int k1 = 0;
        while (i < n1 && j < n2)
        {
            if (arr1[i] < arr2[j])
            {
                count++;
                if (count == k)
                {
                    return arr1[i];
                }
                i++;
            }
            else
            {
                count++;
                if (count == k)
                {
                    return arr2[j];
                }
                j++;
            }
        }
        while (i < n1)
        {
            count++;
            if (count == k)
            {
                return arr1[i];
            }
            i++;
        }
        while (j < n2)
        {
            count++;
            if (count == k)
            {
                return arr2[j];
            }
            j++;
        }
        return -1;
    }
    // TC : O(k)
    // SC : O(1)

    // using binary search


    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k)
    {
        if (m > n)
        {
            return kthElement(b, a, n, m, k);
        }

        int left = k; // length of left half

        // apply binary search:
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high)
        {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < m)
            {
                r1 = a.get(mid1);
            }
            if (mid2 < n)
            {
                r2 = b.get(mid2);
            }
            if (mid1 - 1 >= 0)
            {
                l1 = a.get(mid1 - 1);
            }
            if (mid2 - 1 >= 0)
            {
                l2 = b.get(mid2 - 1);
            }

            if (l1 <= r2 && l2 <= r1)
            {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2)
            {
                high = mid1 - 1;
            }
            else
            {
                low = mid1 + 1;
            }
        }
        return 0; // dummy statement
    }


}
