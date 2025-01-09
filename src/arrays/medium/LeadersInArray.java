package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInArray
{
    public static void main(String[] args)
     {
        int[] arr = {10, 22, 12, 3, 0, 6};
        print(bruteForce(arr));
        print(better(arr));
    }

    private static int[] bruteForce(int[] arr)
    {
        int n = arr.length;
        int[] ans = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            boolean leader = true;
            for (int k = i + 1; k < n; k++)
            {
                if (arr[i] <= arr[k])
                {
                    leader = false;
                    break;
                }
            }
            if (leader)
            {
                ans[j++] = arr[i];
            }
        }
        return ans;
    }
    // TC : O(N^2)
    // SC : O(N)

    private static int[] better(int[] arr)
    {
        int n = arr.length;
        ArrayList<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                leaders.add(arr[i]);
            }
        }

        // Convert the leaders list to an array in reverse order
        int[] result = new int[leaders.size()];
        for (int i = 0; i < leaders.size(); i++) {
            result[i] = leaders.get(leaders.size() - 1 - i); // Reverse the order
        }

        return result;
    }
    // TC : O(N)
    // SC : O(N)
    // TC : O(N log N) if sorted

    private static void print(int[] arr)
    {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
