package binarysearch.on2darrays;

public class SearchIn2DMatrix
{
    public static void main(String[] args)
    {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(bruteForce(arr, target));
        System.out.println(optimal(arr, target));
        System.out.println(optima2(arr, target));
    }

    private static boolean bruteForce(int[][] arr, int target)
    {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j] == target)
                {
                    return true;
                }
            }
        }
        return false;
        // TC : O(n * m)
        // SC : O(1)
    }

    private static boolean optimal(int[][] mat, int target)
    {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = (n * m) - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (mat[mid / m][mid % m] == target)
            {
                return true;
            }
            else if (mat[mid / m][mid % m] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return false;
        // TC : O(log(n * m))
        // SC : O(1)
    }

    private static boolean optima2(int[][] arr, int target)
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
        return false;
    }

    public static boolean binarySearch(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return true;
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
        return false;
    }

}