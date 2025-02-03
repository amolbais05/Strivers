package arrays.hard;

import java.util.Arrays;

public class FindRepeatingAndMissingNumber
{
    public static void main(String[] args)
    {
        int[] arr = {4, 3, 6, 2, 1, 1};
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
}
