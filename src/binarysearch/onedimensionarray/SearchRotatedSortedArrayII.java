package binarysearch.onedimensionarray;

public class SearchRotatedSortedArrayII
{
    public static void main(String[] args)
    {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3;
        System.out.println(bruteForce(arr, target));
        System.out.println(optimal(arr, target));
    }

    private static boolean bruteForce(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == target)
            {
                return true;
            }
        }
        return false;
    }
    // TC : O(n)
    // SC : O(1)

    private static boolean optimal(int[] nums, int target)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
            {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end])
            {
                start++;
                end--;
                continue;
            }
            if (nums[start] <= nums[mid]) // check if left half is sorted
            {
                if (nums[start] <= target && nums[mid] >= target)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else
            {
                if (nums[mid] <= target && nums[end] >= target)
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    // TC : O(log n)
    // SC : O(1)
}
