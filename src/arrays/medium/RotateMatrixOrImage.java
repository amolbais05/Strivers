package arrays.medium;

public class RotateMatrixOrImage
{
    public static void main(String[] args)
    {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        bruteForce(arr);
        print(arr);
        arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        better(arr);
        System.out.println("-------------");
        print(arr);
    }

    private static void bruteForce(int[][] arr)
    {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ans[j][n - i - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = ans[i][j];
            }
        }
    }
    // TC : O(N^2)
    // SC : O(N^2)


    private static void better(int[][] arr)
    {
        int n = arr.length;
        // transpose
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n/2; j++)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[i][n - j - 1];
                arr[i][n - j - 1] = temp;
            }
        }
    }
    /// TC : O(N^2)
    // SC : O(1)

    private static void print(int[][] arr)
    {
        for (int[] ints : arr)
        {
            for (int j = 0; j < arr.length; j++)
            {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
