package recursion;

import java.util.stream.IntStream;

public class ReverArray
{
    public static void main(String[] args)
    {
        reversArray(new int[]{1, 2, 3, 4, 5});
        reverseArrayInPlace(new int[]{1, 2, 3, 4, 5});
        recursive(new int[]{1, 2, 3, 4, 5}, 0, 4);
    }

    private static int[] reversArray(int[] arr)
    {
        int newArr[] = new int[arr.length];
        int cnt = 0;
        for (int i = arr.length - 1; i >= 0 ; i--)
        {
            newArr[cnt] = arr[i];
            cnt++;
        }
        return newArr;
    }
    // TC : O (n)
    // SC : O (n)

    private static int[] reverseArrayInPlace(int[] arr)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
    // TC : O (n)
    // SC : O (1)

    private static void recursive(int arr[], int start, int end)
    {
        while(start >= end)
        {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        recursive(arr, start + 1, end - 1);
        // TC : O (n)
        // SC : O (1)
    }

}
