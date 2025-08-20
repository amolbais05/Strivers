package recursion.lec1;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutation
{

    // Approach 1 : Using extra space
    // SC : O (n) + O (n)
    // TC : O (n! * n)
    private static void permute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq)
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
                permute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    // Approach 2 : Without using extra space
    // SC : O (1)
    // TC : O (n! * n)
    private static void permute(int index, int[] nums, List<List<Integer>> ans)
    {
        if (index == nums.length)
        {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
            {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++)
        {
            swap(nums, i, index);
            permute(index + 1, nums, ans);
            swap(nums, i, index);
        }
    }

    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
