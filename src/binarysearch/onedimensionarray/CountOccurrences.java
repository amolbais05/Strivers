package binarysearch.onedimensionarray;

public class CountOccurrences
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10};
        int target = 4;
        System.out.println(bruteForce(arr, target));
        System.out.println(optimal(arr, target));
    }
    private static int bruteForce(int[] nums, int target)
    {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] == target)
            {
                count++;
            }
        }
        return count;
    }
    // TC : O(n)
    // SC : O(1)

    private static int optimal(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int firstOccurrence = -1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                firstOccurrence = mid;
                high = mid - 1;
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
        return firstOccurrence;
    }
    // TC : O(log n)
    // SC : O(1)
}
