package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum
{
    public static void main(String[] args)
    {
        int arr[] = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = better(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
        System.out.println(ans[0] + " " + ans[1]);
    }


    private static int[] bruteForce(int arr[], int target)
    {
        int n = arr.length;
        for (int i =0 ; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (arr[i] + arr[j] == target)
                {
                    return new int[]{i , j};
                }

            }
        }
        return new int[] {-1, -1};
    }
    // TC : O(N^2)
    // SC : O(1)

    private static int[] better(int arr[], int target)
    {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            int numberNeeded = target - arr[i];
            if (map.containsKey(numberNeeded))
            {
                return new int[] {map.get(numberNeeded), i};
            }
            map.put(arr[i], i);

        }
        return new int[] {-1, -1};
    }
    // TC : O(N)
    // SC : O(N)

    private static String optimal(int arr[], int target)
    {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        Arrays.sort(arr);
        while (left < right)
        {
            int sum = arr[left] + arr[right];

            if (sum == target)
            {
                return "YES";
            }
            else if (sum < target)
            {
                left ++;
            }
            else
            {
                right --;
            }

        }
        return "NO";
    }
    // TC : O(N) + O(NlogN) =  O(NlogN)
    // SC : O(1)


}
