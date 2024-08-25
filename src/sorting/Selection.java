package sorting;

import java.util.stream.IntStream;

public class Selection
{
    public static void main(String[] args)
    {
        int arr[] = {4, 3, 1, 6, 7, 8, 9, 0};
        sort(arr);
        IntStream.of(arr).forEach(System.out::print);

    }
    public static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n ; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }

    }

    private static void swap(int[] arr, int i, int minIndex)
    {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;

    }
    // TC : O(N^2)

}
