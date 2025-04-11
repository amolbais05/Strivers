package binarysearch.on2darrays;

import java.util.Arrays;

public class MedianOfRowWiseSortedMatrix
{
    public static void main(String[] args)
    {
        int[][] arr = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int[] temp = new int[n * m];
        int k = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                temp[k++] = arr[i][j];
            }
        }
        Arrays.sort(temp);
        return temp[temp.length / 2];
    }
    // TC : O(n * m)
    // SC : O(n * m)

    private static int optimal(int[][] arr)
    {
        


    }
}
