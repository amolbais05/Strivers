package sorting;

import java.util.stream.IntStream;

public class Insertion
{
    public static void main(String[] args)
    {
        int arr[] = {3 ,2 ,1, 4, 6,5};
        recursive(arr, arr.length, 0);
        IntStream.of(arr).forEach(System.out::print);
    }

    private static int[] sort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j])
            {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }

        }
        return arr;
    }
    // Avg and Worst : O(N^2)
    // Best if array is sorted O(N)

    private static void recursive(int[] arr, int n, int i)
    {
            if (i == n)
            {
                return;
            }
            int j = i;
            while (j > 0 && arr[j-1] > arr[j])
            {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        recursive(arr, n, i + 1);
    }
}
