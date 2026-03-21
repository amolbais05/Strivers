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

    // Bottom-up approach
    public int solve(int[] arr)
    {
        int n = arr.length;
        if (n == 1)
        {
            return arr[0];
        }
        int[] dp = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++)
        {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];

    }

    // Space optimization
    public int solveSpaceOptimization(int[] arr)
    {
        int n = arr.length;
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return arr[0];
        }

        int prev2 = 0;
        int prev = arr[0];

        for (int i = 1; i < n; i++)
        {
            int include = arr[i] + prev2;
            int exclude = prev;

            int curr = Math.max(include, exclude);

            prev2 = prev;
            prev = curr;

        }

        return prev;

    }


}
