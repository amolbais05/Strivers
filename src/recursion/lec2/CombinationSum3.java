package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3
{
    public static void main(String[] args)
    {
        int k = 3, n = 7;
        List<List<Integer>> ans = combinationSum3(k, n);

        System.out.println(ans);
    }

    public static List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int start, int k, int target, List<Integer> current, List<List<Integer>> ans)
    {
        // if valid combination found
        if (current.size() == k && target == 0)
        {
            ans.add(new ArrayList<>(current));
            return;
        }

        // prune if overshoot
        if (current.size() > k || target < 0)
        {
            return;
        }

        for (int i = start; i <= 9; i++)
        {
            current.add(i);
            backtrack(i + 1, k, target - i, current, ans); // move forward (no reuse)
            current.remove(current.size() - 1); // backtrack
        }
    }
}
