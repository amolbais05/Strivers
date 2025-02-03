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

    private static int[] findMissingAndDuplicateUsingXOR(int[] nums)
    {
        int xor = 0;
        int n = nums.length;

        // Step 1: XOR all numbers from 1 to n and all array elements
        for (int i = 1; i <= n; i++) xor ^= i;
        for (int num : nums) xor ^= num;

        // Step 2: Find rightmost set bit (difference identifier)
        int diffBit = xor & -xor;

        // Step 3: Divide numbers into two groups & XOR separately
        int xor1 = 0, xor2 = 0;
        for (int num : nums)
        {
            if ((num & diffBit) == 0) xor1 ^= num;
            else xor2 ^= num;
        }
        for (int i = 1; i <= n; i++)
        {
            if ((i & diffBit) == 0) xor1 ^= i;
            else xor2 ^= i;
        }

        // Step 4: Identify missing & duplicate
        for (int num : nums)
        {
            if (num == xor1) return new int[]{xor1, xor2}; // xor1 = duplicate
        }
        return new int[]{xor2, xor1}; // xor2 = duplicate
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
