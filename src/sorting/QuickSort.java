package sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort
{
    public static void main(String[] args)
    {
        int arr[] = {5, 4, 3, 2, 1};
        int[] result = quickSort(arr);
        for (int i : result)
        {
            System.out.print(i + " ");
        }
    }

    private static int[] quickSort(int[] arr)
    {
        if (arr.length < 2)
        {
            return arr; // already sorted
        }

        int pivot = arr[0];

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) // Skip the pivot element
        {
            if (arr[i] <= pivot)
            {
                less.add(arr[i]);
            }
            else
            {
                greater.add(arr[i]);
            }
        }

        // Recursively sort less and greater lists
        int[] sortedLess = quickSort(less.stream().mapToInt(Integer::intValue).toArray());
        int[] sortedGreater = quickSort(greater.stream().mapToInt(Integer::intValue).toArray());

        // Combine the sorted lists and pivot
        int[] result = new int[arr.length];
        int index = 0;

        // Copy the sorted less list
        for (int num : sortedLess)
        {
            result[index++] = num;
        }

        // Add the pivot
        result[index++] = pivot;

        // Copy the sorted greater list
        for (int num : sortedGreater)
        {
            result[index++] = num;
        }

        return result;
    }
    // TC : O (NLog(N))
    // SC : O(N)
}
