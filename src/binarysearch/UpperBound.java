package binarysearch;

public class UpperBound
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 18;
        System.out.println(bruteForceiterative(arr, target));
        System.out.println(optimal(arr, target));
    }

    private static int bruteForceiterative(int[] nums, int target)
    {
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > target)
            {
                return i;
            }
        }
        return n;
    }
    // TC : O(n)
    // SC : O(1)

    private static int optimal(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)
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
    // TC : O(log n)
    // SC : O(1)
}
