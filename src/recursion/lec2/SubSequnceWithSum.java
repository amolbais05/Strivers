package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class SubSequnceWithSum
{
    public static void main(String[] args)
    {

    }

    private static void sumOfSubSubSequence(int[] arr, int index, int targetSum, int currentSum, List<List<Integer>> result,
        List<Integer> current)
    {
        if (arr.length == index)
        {
            if (currentSum == targetSum)
            {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // pick the element
        current.add(arr[index]);
        sumOfSubSubSequence(arr, index + 1, targetSum, currentSum + arr[index], result, current);
        current.remove(current.size() - 1);

        // not pick the element
        sumOfSubSubSequence(arr, index + 1, targetSum, currentSum, result, current);
    }
    // TC : O (2^n)
    // SC : O (n)


}
