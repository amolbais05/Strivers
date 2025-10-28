package greedy.lec2;

import java.util.Arrays;

public class JumpGameII
{
    public int bruteForce(int[] nums)
    {
        return minJump(nums, 0);
    }

    private int minJump(int[] nums, int position)
    {
        if (position >= nums.length - 1)
        {
            return 0;
        }

        if (nums[position] == 0)
        {
            return Integer.MAX_VALUE;
        }

        int minStep = Integer.MAX_VALUE;

        for (int jump = 1; jump <= nums[position]; jump++)
        {
            int subResult = minJump(nums, position + jump);
            if (subResult != Integer.MAX_VALUE)
            {
                minStep = Math.min(minStep, 1 + subResult);
            }
        }
        return minStep;
    }
    // TC : O(2^N)
    // SC : O(N)

    public int betterUsingDP(int[] nums)
    {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // start index requires 0 jumps

        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j <= nums[i] && i + j < n; j++)
            {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }
    // TC : O(N^2)
    // SC : O(N)

    public int optimal(int[] nums)
    {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++)
        {
            farthest = Math.max(farthest, i + nums[i]);

            if (currentEnd == i)
            {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
    // TC : O(N)
    // SC : O(1)
}
