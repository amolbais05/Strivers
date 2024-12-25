package arrays.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        int n = arr1.length;
        int m = arr2.length;
        int[] result = optimal(arr1, arr2, n, m);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }


    private static int[] bruteForce(int arr1[], int arr2[], int n, int m)
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
            set.add(arr1[i]);
        }
        for (int i = 0; i < m; i++)
        {
            set.add(arr2[i]);
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (Integer s : set)
        {
          result[i] = s;
          i++;
        }
        return result;
    }
    // TC : O(N+M)
    // SC : O(N+M)


    private static int[] optimal(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m)
        {
            if (arr1[i] <= arr2[j])
            {
                if (union.size() == 0 || !union.contains(arr1[i]))
                {
                    union.add(arr1[i]);
                }
                i++;
            }
            else
            {
                if (union.size() == 0 || !union.contains(arr2[j]))
                {
                 union.add(arr2[j]);
                }
                j++;
            }

        }
        while (i < n)
        {
            if (!union.contains(arr1[i]))
            {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < m)
        {
            if (!union.contains(arr2[j]))
            {
                union.add(arr2[j]);
            }
            j++;
        }

        return union.stream().mapToInt(Integer::intValue).toArray();
    }
    // TC : O(N+M)
    // SC : O(N+M)


}
