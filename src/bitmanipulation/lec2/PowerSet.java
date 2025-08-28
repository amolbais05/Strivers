package bitmanipulation.lec2;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
    private List<List<Integer>> subsets(int[] nums)
    {
        int n = nums.length;
        int total = 1 << n; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < total; mask++)
        {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                // check if j-th bit is set in mask
                if ((mask & (1 << j)) != 0)
                {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    // TC : O(n * 2^n)
    // SC : O(n * 2^n)
}
