package binarysearch.on2darrays;

public class RowWithMaximumNumberOf1
{
    public static void main(String[] args)
    {
        int[][] arr = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int max = 0;
        int index = -1;
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j] == 1)
                {
                    count++;
                }
            }
            if (count > max)
            {
                max = count;
                index = i;
            }
        }
        return index;
    }
    // TC : O(n * m)
    // SC : O(1)

    private static int optimal(int[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        int max = 0;
        int index = -1;

        for (int i = 0; i < n; i++)
        {
            int cnt = m - lowerBound(arr[i], 1);

            if (cnt > max)
            {
                max = cnt;
                index = i;
            }
        }
        return index;
    }
    // TC : n * log m
    // SC : O(1)

    private static int lowerBound(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }


}
