package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency
{
    public static void main(String[] args)
    {
        int arr[] ={10,5,10,15,10,5};
        int n = arr.length;
        countFreq(arr, n);
        usingMap(arr, n);
    }
    public static void countFreq(int arr[], int n)
    {
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (visited[i] == true)
                continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }
    // TC: O(N^2)
    // SC: O(n)

    public static void usingMap(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            if (map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }
        // Traverse through map and print frequencies
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    // TC: O(N)
    // SC: O(n)
}
