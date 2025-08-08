package recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
    public static void main(String[] args)
    {
     //   System.out.println(powerSetIterative(new int[]{1, 2, 3}));
        List<List<Integer>> result = new ArrayList<>();
        powerSetRecursive(0, new int[]{1, 2, 3}, new ArrayList<>(), result);

        System.out.println(result);
    }

        private static List<List<Integer>> powerSetIterative ( int[] nums)
        {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (Integer num : nums)
            {
                List<List<Integer>> subSet = new ArrayList<>();
                for (List<Integer> set : result)
                {
                    List<Integer> newSet = new ArrayList<>(set); // IMPORTANT
                    newSet.add(num);
                    subSet.add(newSet);
                }
                result.addAll(subSet);
            }
            return result;
        }
    // TC : O (n * 2^n)
    // SC : O (n * 2^n)

    private static void powerSetRecursive (int index, int[] nums, List<Integer> current, List<List<Integer>> result)
    {
        if (nums.length == index)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        // pick the element
        current.add(nums[index]);
        powerSetRecursive(index + 1, nums, current, result);
        current.remove(current.size() - 1);

        // not pick the element
        powerSetRecursive(index + 1, nums, current, result);
    }
    // TC : O (n * 2^n)
    // SC : O (n * 2^n)
}
