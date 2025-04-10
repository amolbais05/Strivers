package binarysearch.on2darrays;

public class SearchIn2DMatrixII
{
    public static void main(String[] args)
    {
        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(bruteForce(arr, target));
        System.out.println(better(arr, target));
        System.out.println(optimal(arr, target));
    }

    private static int[] bruteForce(int[][] mat, int target)
    {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (mat[i][j] == target)
                {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    // TC : O(n * m)
    // SC : O(1)

    private static int[] better(int[][] arr, int target)
    {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++)
        {

            if (arr[i][0] <= target && arr[i][m - 1] >= target)
            {
                return binarySearch(arr[i], target);
            }
        }
        return new int[]{-1, -1};
    }
    // TC : O(n * log m)
    // SC : O(1)

    private static boolean optimal(int[][] arr, int target)
    {
        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0)
        {
            if (arr[i][j] == target)
            {
                return true;
            }
            else if (arr[i][j] < target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return false;
    }
    // TC : O(n + m)
    // SC : O(1)

    public static int[] binarySearch(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return new int[]{low, high};
            }
            else if (target > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}