package dp;

public class MaximumSumOfAdjacentElement
{
    // Top down approach
    public int solve(int[] arr, int i, int[] dp)
    {
        if (i < 0)
        {
            return 0;
        }
        if (i == 0)
        {
            return arr[0];
        }
        if (dp[i] != -1)
        {
            return dp[i];
        }

        int pick = solve(arr, i - 2, dp);
        int notPick = solve(arr, i - 1, dp);

        return dp[i] = Math.max(pick, notPick);

    }

    
}
