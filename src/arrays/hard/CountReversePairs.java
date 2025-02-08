package arrays.hard;

import java.util.ArrayList;

/**
Problem Statement: Given an array of numbers, you need to return the count of reverse pairs.
 Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Example 1:
Input: array[] = {1,3,2,3,1)
Output : 2
Explanation: The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.

Example 2:
Input: array[] = {3,2,1,4}
Output: 1
Explaination: There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]

 *
 * */

public class CountReversePairs
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 2, 3, 1};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > 2 * arr[j])
                {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static int optimal(int[] nums)
    {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);

    }
    public static int mergeSort(int[] arr, int low, int high)
    {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); //Modification
        merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int countPairs(int[] arr, int low, int mid, int high)
    {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++)
        {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

}
