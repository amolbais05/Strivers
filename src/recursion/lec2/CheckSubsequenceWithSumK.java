package recursion.lec2;

public class CheckSubsequenceWithSumK
{
    private static boolean hasSumOfSubsequence(int[] arr, int index, int targetSum, int currentSum)
    {
        if (arr.length == index)
        {
            return currentSum == targetSum;
        }

        // pick the element
        if (hasSumOfSubsequence(arr, index + 1, targetSum, currentSum + arr[index]))
        {
            return true;
        }

        // not pick the element
        if (hasSumOfSubsequence(arr, index + 1, targetSum, currentSum))
        {
            return true;
        }
        return false;
    }
}
