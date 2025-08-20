package recursion.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSet_II
{
    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2};
        Arrays.sort(arr); // sort to handle duplicates easily
        Set<List<Integer>> result = new HashSet<>();
        powerSetRecursive(0, arr, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void powerSetRecursive(int index, int[] nums, List<Integer> current, Set<List<Integer>> result)
    {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++)
        {
            // skip duplicates
            if (i > index && nums[i] == nums[i - 1])
            {
                continue;
            }

            current.add(nums[i]);
            powerSetRecursive(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
