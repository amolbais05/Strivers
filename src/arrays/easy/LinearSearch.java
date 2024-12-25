package arrays.easy;

import java.util.stream.IntStream;

public class LinearSearch
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(linearSearchUsingStream(arr, 3));
        System.out.println(linearSearchUsingStream(arr, 7));
        System.out.println(linearSearchUsingStream(arr, 1));
    }

    private static int linearSearch(int arr[], int target)
        {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(N)
    // SC : O(1)

    private static int linearSearchUsingStream(int arr[], int target)
    {
        return IntStream.range(0, arr.length)
            .filter(i -> arr[i] == target)
            .findFirst()
            .orElse(-1);
    }
    // TC : O(N)
    // SC : O(1)
}
