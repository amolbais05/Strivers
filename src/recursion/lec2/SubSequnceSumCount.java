package recursion.lec2;


import java.util.ArrayList;

public class SubSequnceSumCount
{

    private static int sumOfSubSubSequence(int[] arr, int index, int targetSum, int currentSum, ArrayList<Integer> current)
    {
        if (arr.length == index)
        {
            return (targetSum == currentSum) ? 1 : 0;
        }

        // pick the element
        current.add(arr[index]);
        int pick = sumOfSubSubSequence(arr, index + 1, targetSum, currentSum + arr[index], current);
        current.remove(current.size() - 1);

        // not pick the element
        int notPick = sumOfSubSubSequence(arr, index + 1, targetSum, currentSum, current);

        return pick + notPick;
    }
    // TC : O (2^n)
    // SC : O (n)

}
