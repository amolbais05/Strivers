package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions
{
    public static void main(String[] args)
    {
        int[] arr = {5, 3, 2, 1, 4};
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
                if (arr[i] > arr[j])
                {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(n^2)
    // SC : O(1)

    // using merge sort
    private static int optimal(int[] arr)
    {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    private static int mergeSort(int arr[], int low, int high)
    {
        int count = 0;
        if (low == high)
        {
            return count;
        }
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count +=mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high)
    {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;
        while (left <= mid && right <=high)
        {
            if (arr[left] <= arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            //
            else
            {
                temp.add(arr[right]);
                right++;
                count += mid - left + 1;
            }
        }

        while (left <= mid)
        {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high)
        {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high ; i++)
        {
            arr[i] = temp.get(i - low);
        }

        return count;
    }
    // TC : O(nlogn)
    // SC : O(n)

}
