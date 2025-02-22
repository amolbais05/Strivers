package binarysearch.onedimensionarray;

public class FindMinimumInRotatedSortedArray
{
    public static void main(String[] args)
    {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[] nums)
    {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    // TC : O(n)
    // SC : O(1)

    private static int better(int[] nums)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid])
            {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            }
            else
            {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
    // TC : O(log n)
    // SC : O(1)

    private static int optimal(int[] nums)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            // if array is not rotated
            if (nums[start] <= nums[end])
            {
                min = Math.min(min, nums[start]);
                break;
            }

            if (nums[start] <= nums[mid])
            {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            }
            else
            {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
    // TC : O(log n)
    // SC : O(1)


}
