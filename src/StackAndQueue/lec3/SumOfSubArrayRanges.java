package StackAndQueue.lec3;

import java.util.Stack;

public class SumOfSubArrayRanges
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 1, 4};
        int n = arr.length;
        long arrRange = getSum(arr, true) - getSum(arr, false);
    }

    private static int bruteForce(int[] nums)
    {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            int max = nums[i];
            int min = nums[i];
            for (int j = i; j < n; j++)
            {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static long getSum(int[] nums, boolean isMax)
    {
        int n = nums.length;
        int[] left = countSubarraysLeft(nums, isMax, n);
        int[] right = countSubarraysRight(nums, isMax, n);

        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += (long) nums[i] * left[i] * right[i];
        }
        return sum;
    }

    private static int[] countSubarraysRight(int[] nums, boolean isMax, int n)
    {
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stack.isEmpty() && (isMax ? nums[stack.peek()] < nums[i] : nums[stack.peek()] > nums[i]))
            {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        return right;
    }

    private static int[] countSubarraysLeft(int[] nums, boolean isMax, int n)
    {
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && (isMax ? nums[stack.peek()] <= nums[i] : nums[stack.peek()] >= nums[i]))
            {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return left;
    }


}
