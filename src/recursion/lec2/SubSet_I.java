package recursion.lec2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSet_I
{
    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2};
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        subsetSum(0, 0, arr, n, result);
        Collections.sort(result);

    }

    private static void subsetSum(int index, int sum, int[] arr, int n, List<Integer> result)
    {
        if (index == n)
        {
            result.add(sum);
            return;
        }
        // pick the element
        subsetSum(index + 1, sum + arr[index], arr, n, result);

        // not pick the element
        subsetSum(index + 1, sum, arr, n, result);
    } // TC : O (2^n)
    // SC : O (n)
}