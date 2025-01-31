package arrays.hard;

import java.util.HashMap;

public class LargestSubarrayWith0Sum
{
    public static void main(String[] args)
    {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(bruteForce(arr));
    }

    private static int bruteForce(int[] arr)
    {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int sum = 0;
            for (int j = i; j < arr.length; j++)
            {
                sum += arr[j];
                if (sum == 0)
                {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static int optimal(int[] arr)
    {
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if (sum == 0)
            {
                max = i + 1;
            }
            else
            {
                if (map.get(sum) != null)
                {
                    max = Math.max(max, i - map.get(sum));
                }
                else
                {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
    // TC : O(n)
    // SC : O(n)

}
