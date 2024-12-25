package arrays.easy;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        int n = arr1.length;
        int m = arr2.length;
        int[] result = bruteForce(arr1, arr2, n, m);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] bruteForce(int arr1[], int arr2[], int n, int m)
    {
        int[] visited = new int[n];
        ArrayList<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (arr1[j] == arr2[i] && visited[j] == 0)
                {
                    System.out.print(arr2[i] + " ");
                    visited[j] = 1;
                    intersection.add(arr2[i]);
                    break;
                }
                if (arr1[j] > arr2[i])
                {
                 break;
                }

            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
    // TC : O(N*M)
    // SC : O(N)

    private static int[] twoPointerIntersection(int arr1[], int arr2[])
    {
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i] < arr2[j])
            {
                i++;
            }
            else if (arr1[i] > arr2[j])
            {
                j++;
            }
            else
            {
                if (intersection.isEmpty() || intersection.get(intersection.size() - 1) != arr1[i])
                {
                    intersection.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }


}
