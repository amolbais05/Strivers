package greedy.lec2;

public class JumpGame
{
    public boolean canJumpGreedy(int[] nums)
    {

        int reachable = 0;

        for (int index = 0; index < nums.length; index++)
        {
            if (reachable < index)
            {
                return false;
            }
            reachable = Math.max(reachable, index + nums[index]);

        }
        return true;
    }

    public boolean canJumpUsingDP(int[] nums)
    {
        Boolean[] dp = new Boolean[nums.length];
        return solve(nums, 0, dp);

    }

    private boolean solve(int[] nums, int index, Boolean[] dp)
    {
        if (index >= nums.length - 1)
        {
            return true;
        }
        if (dp[index] != null)
        {
            return dp[index];   // reuse result
        }

        for (int jump = 1; jump <= nums[index]; jump++)
        {
            if (solve(nums, index + jump, dp))
            {
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}
