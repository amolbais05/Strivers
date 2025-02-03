package arrays.hard;

import java.util.Arrays;

public class FindRepeatingAndMissingNumber
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 6};
        int[] ans = optimal(arr);
        Arrays.stream(ans).forEach(System.out::print);

    }

    private static int[] optimal(int[] nums)
    {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
            {
                ans[0] = index + 1; // Duplicate found
            }
            else
            {
                nums[index] = -nums[index]; // Mark index negative
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
            {
                ans[1] = i + 1; // Missing number
                break;
            }
        }
        return ans;
    }
    // TC : O (n)
    // SC : O (1)

    private static int[] usingHashArray(int[] nums)
    {
        int[] ans = new int[2];
        int[] hash = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
        {
            hash[nums[i]]++;
        }
        for (int i = 1; i < hash.length; i++)
        {
            if (hash[i] == 2)
            {
                ans[0] = i;
            }
            else if (hash[i] == 0)
            {
                ans[1] = i;
            }
        }
        return ans;
    }
    // TC : O (n)
    // SC : O (1)

    private static int[] bruteForce(int[] nums)
    {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            int count = 0;
            for (int j = 0; j < nums.length; j++)
            {
                if (nums[j] == i + 1)
                    count++;
            }
            if (count == 2)
                ans[0] = i + 1;  // Duplicate
            else if (count == 0)
                ans[1] = i + 1;  // Missing
        }
        return ans;
    }
    // TC : O (n^2)
    // SC : O (1)

}
