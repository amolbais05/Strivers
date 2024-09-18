package sorting;

import java.util.Arrays;

public class Quick
{
    public static void main(String[] args)
    {
        int arr[] = {5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }
    // TC : O (NLog(N))
    // SC : O(1)

    private static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j)
        {
            while (arr[i] <= pivot && i <= high - 1)
            {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1)
            {
                j--;
            }
            if (i < j)
            {
                swap(arr, i, j);
            }
        }
        // Swap pivot with the element at j
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
