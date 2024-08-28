package sorting;

import java.util.stream.IntStream;

public class Insertion
{
    public static void main(String[] args)
    {
        int arr[] = {3 ,2 ,1, 4, 6,5};
        IntStream.of(sort(arr)).forEach(System.out::print);
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
}
