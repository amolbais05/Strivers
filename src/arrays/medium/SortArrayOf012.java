package arrays.medium;

import java.util.Arrays;

public class SortArrayOf012
{
    public static void main(String[] args)
    {
        int[] arr = {0 , 1, 2, 0, 1, 2, 0, 1, 2, 0};
        better(arr);

        int[] arr2 = {0 , 1, 2, 0, 1, 2, 0, 1, 2, 0};
        dutchNationalFlag(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    private static void better(int[] arr)
    {
        int zero = 0;
        int one = 0;
        int two = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == 0)
            {
                zero++;
            }
            else if (arr[i] == 1)
            {
                one++;
            }
            else
            {
                two++;
            }
        }

        for (int i = 0 ; i < zero ; i++)
        {
            arr[i] = 0;
        }
        for (int i = zero ; i < zero + one ; i++)
        {
            arr[i] = 1;
        }
        for (int i = zero + one; i < n; i++)
        {
            arr[i] = 2;
        }
    }
    // TC : O(N)
    // SC : O(1)

    private static void dutchNationalFlag(int[] arr)
    {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high)
        {
            switch (arr[mid])
            {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    // TC : O(N)
    // SC : O(1)


    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
