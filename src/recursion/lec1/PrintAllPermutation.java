package recursion.lec1;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutation
{

    // Approach 1 : Using extra space
    // SC : O (n) + O (n)
    // TC : O (n! * n)
    private static void printPermutation(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq)
    {

        if (ds.size() == nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (!freq[i])
            {
                freq[i] = true;
                ds.add(nums[i]);
                printPermutation(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}
