package arrays.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestElement
{
    public static void main(String[] args)
    {
        System.out.println(largestElement(new int[]{2,5,1,3,0}));
        System.out.println(largestElementUsingStream(new int[]{8,10,5,7,9}));
        System.out.println(largestElementUsingSort(new int[]{2,5,1,3,0}));
    }
    private static int largestElement(int arr[])
    {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    //  TC : O(N)
    //  SC : O(1)

    private static int largestElementUsingStream(int arr[])
    {
        return IntStream.of(arr).max().getAsInt();
    }
    //  TC : O(N)
    //  SC : O(1)

    private static int largestElementUsingSort(int arr[])
    {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
    //  TC : O(N*log(N))
    //  SC : O(N)
}
