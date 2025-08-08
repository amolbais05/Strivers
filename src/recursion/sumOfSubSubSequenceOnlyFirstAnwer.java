package recursion;

import java.util.ArrayList;

public class sumOfSubSubSequenceOnlyFirstAnwer
{

    private static boolean sumOfSubSubSequence(int[] arr, int index, int targetSum, int currentSum, ArrayList<Integer> current)
    {
        if (arr.length == index)
        {
            if (currentSum == targetSum)
            {
                System.out.println(current);
                return true;
            }
            return false;
        }

        // pick the element
        current.add(arr[index]);
        if (sumOfSubSubSequence(arr, index + 1, targetSum, currentSum + arr[index], current))
        {
            return true;
        }
        current.remove(current.size() - 1);

        // not pick the element
        return sumOfSubSubSequence(arr, index + 1, targetSum, currentSum, current);
    }
    // TC : O (2^n)
    // SC : O (n)

}
