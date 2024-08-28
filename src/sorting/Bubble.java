package sorting;

import java.util.stream.IntStream;

public class Bubble
{

    public static void main(String[] args)
    {
        int arr[] = {3 ,2 ,1, 4, 6,5};
        IntStream.of(sort(arr)).forEach(System.out::print);
    }
    public static int[] sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n ; j++)
            {
                if (arr[j] < arr[i])
                {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
        return arr;
    }
    // TC : O(N^2)

    public static int[] optimize(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            boolean flag = false;
            for (int j = i + 1; j < n ; j++)
            {
                if (arr[j] < arr[i])
                {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
            if (!flag)
            {
                break;
            }

        }
        return arr;
    }
    // O(N) when array is already sorted

    // Space Complexity: O(1)O(1)
}