package dp;

import java.util.ArrayList;

public class HouseRobber
{
    public int solve(int[] nums)
    {

        int n = nums.length;
        if (n == 1)
        {
            return nums[0];
        }
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            if (i != 0)
            {
                temp1.add(nums[i]);
            }
            if (i != n - 1)
            {
                temp2.add(nums[i]);
            }
        }
        return Math.max(solveSpaceOptimization(temp1.stream().mapToInt(Integer::intValue).toArray()),
            solveSpaceOptimization(temp2.stream().mapToInt(Integer::intValue).toArray()));

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
