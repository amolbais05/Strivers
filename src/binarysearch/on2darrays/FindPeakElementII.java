package binarysearch.on2darrays;

public class FindPeakElementII
{
    public static void main(String[] args)
    {
        int[][] arr = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if ((i == 0 || arr[i][j] > arr[i - 1][j]) &&
                    (i == n - 1 || arr[i][j] > arr[i + 1][j]) &&
                    (j == 0 || arr[i][j] > arr[i][j - 1]) &&
                    (j == m - 1 || arr[i][j] > arr[i][j + 1]))
                {
                    return arr[i][j];
                }
            }
        }
        return -1;
    }
    // TC : O(n * m)
    // SC : O(1)

    private static int optimal(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int low = 0;
        int high = n - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < m; i++)
            {
                if (arr[mid][i] > max)
                {
                    max = arr[mid][i];
                    maxIndex = i;
                }
            }
            if (mid == 0 || arr[mid][maxIndex] > arr[mid - 1][maxIndex])
            {
                if (mid == n - 1 || arr[mid][maxIndex] > arr[mid + 1][maxIndex])
                {
                    return arr[mid][maxIndex];
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
    // TC : O(n * log m)
    // SC : O(1)

}
