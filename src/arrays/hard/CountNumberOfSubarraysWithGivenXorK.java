package arrays.hard;

import java.util.HashMap;

public class CountNumberOfSubarraysWithGivenXorK
{
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(bruteForce(arr, k));
        System.out.println(optimal(arr, k));
    }

    private static int bruteForce(int[] arr, int target)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i; j < arr.length; j++)
            {
                int xor = 0;
                for (int k = i; k <= j; k++)
                {
                    xor = xor ^ arr[k];
                }
                if (xor == target) {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(n^3)
    // SC : O(1)

    private static int better(int[] arr, int k)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int xor = 0;
            for (int j = i; j < arr.length; j++)
            {
                xor ^= arr[j];
                if (xor == k)
                {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static int optimal(int[] arr, int k)
    {
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // xor, frequency
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++)
        {
            xor ^= arr[i];
            int x = xor ^ k;
            if (map.containsKey(x))
            {
                count += map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
    // TC : O(n)
    // SC : O(n)
}
