package binarysearch.onedimensionarray;

public class SearchElementInRotatedSortedArray
{
    public static void main(String[] args)
    {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 0;
        System.out.println(bruteForce(arr, target));
        System.out.println(optimal(arr, target));
    }

    private static int bruteForce(int[] nums, int target)
    {
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(n)
    // SC : O(1)

    private static int optimal(int[] nums, int target)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[start] <= nums[mid]) // check if left half is sorted
            {
                if (nums[start] <= target && target <= nums[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else // right half is sorted
            {
                if (nums[mid] <= target && target <= nums[end])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    // TC : O(log n)
    // SC : O(1)

}
