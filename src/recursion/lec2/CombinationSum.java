package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum
{
    private static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombination(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds)
    {
        if (index == candidates.length)
        {
            if (target == 0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // pick the element
        if (candidates[index] <= target)
        {
            ds.add(candidates[index]);
            findCombination(index, candidates, target - candidates[index], ans, ds);
            ds.remove(ds.size() - 1);
        }

        // not pick the element
        findCombination(index + 1, candidates, target, ans, ds);
    }
    // TC : O (2^t * k)
    // SC : O (k * x)

   
}
