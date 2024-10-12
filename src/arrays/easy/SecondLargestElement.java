package arrays.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SecondLargestElement
{
    public static void main(String[] args)
    {
        System.out.println(secondLargestElementUsingSort(new int[]{8,10,5,7,9}));
        System.out.println(secondLargestElementUsingStream(new int[]{8,10,5,7,9}));
        System.out.println(secondLargestElement(new int[]{8,10,5,7,9}));
        alternateApproach(new int[]{1, 2, 4, 6, 7, 5});
    }

    private static int secondLargestElementUsingSort(int[] arr) // brute force
    {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }
    // TC : O NLog(N)
    // SC : O(1)

    private static int secondLargestElementUsingStream(int[] arr)
    {
        return IntStream.of(arr).skip(2).max().getAsInt();
    }
    // TC : O(N)
    // SC : O(1)

    private static int secondLargestElement(int[] arr)
    {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];

            }
            else if (arr[i] > secondLargest && arr[i] != largest)
            {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    // TC : O(N)
    // SC : O(1)

    private static void alternateApproach(int[] arr)
    {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        int secondLargest = Integer.MIN_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int N = arr.length;

        for (int i = 0; i < N; i++)
        {
            largest = Math.max(largest, arr[i]);
            smallest = Math.min(smallest, arr[i]);
        }

        for (int i = 0; i < N; i++)
        {
            if (arr[i] < secondSmallest && arr[i] != smallest)
            {
                secondSmallest = arr[i];
            }
            if (arr[i] > secondLargest && arr[i] != largest)
            {
                secondLargest = arr[i];
            }
        }
        System.out.println("Second Largest : "+secondLargest);
        System.out.println("Second Smallest : "+secondSmallest);

    }
    // TC : O(N)

}
