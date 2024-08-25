package hashing;

import java.util.HashMap;
import java.util.Map;

public class HighLowFrequency
{
    public static void main(String[] args)
    {
        int arr[] = {10, 5, 10, 15, 10, 5};
        int n = arr.length;
        usingMap(arr, n);
    }

    public static void usingMap(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // Traverse through map and print frequencies
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;
        int maxElement = 0;
        int minElement = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int count = entry.getValue();
            int element = entry.getKey();

            if (count > maxFreq)
            {
                maxElement = element;
                maxFreq = count;
            }
            if (count < minFreq)
            {
                minElement = element;
                minFreq = count;
            }
        }
        System.out.println("The highest frequency element is: " + maxElement);
        System.out.println("The lowest frequency element is: " + minElement);
    }
    // TC: O(N)
    // SC: O(n)

}
