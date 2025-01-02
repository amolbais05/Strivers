package arrays.medium;

import java.util.HashMap;

public class MajorityElement
{
    public static void main(String[] args)
    {
        int arr[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if (arr[i] == arr[j])
                {
                    count++;
                }
                if (count > n / 2)
                {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    // TC : O(N^2)
    // SC : O(1)

    private static int better(int arr[])
    {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > n / 2)
            {
                return arr[i];
            }
        }
        return -1;
    }
    // TC : O(N)
    // SC : O(N)

    // Moore's Voting Algorithm
    private static int optimal(int arr[])
    {
        int n = arr.length;
        int count = 0;
        int element = 0;
        for (int j : arr)
        {
            if (count == 0)
            {
                count = 1;
                element = j;
            }
            else if (j == element)
            {
                count++;
            }
            else
            {
                count--;
            }
        }

        int count1 = 0;
        for (int j : arr)
        {
            if (j == element)
            {
                count1++;
            }
        }
        if (count1 > n / 2)
         {
            return element;
        }
        return -1;
    }
    // TC : O(N)
    // SC : O(1)
}
