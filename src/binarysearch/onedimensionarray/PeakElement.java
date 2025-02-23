package binarysearch.onedimensionarray;

public class PeakElement
{
    public static void main(String[] args)
    {
        System.out.println(bruteForce(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 5, 1}));
        System.out.println(bruteForce(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(bruteForce(new int[]{1, 2, 3, 4, 5}));
        System.out.println(bruteForce(new int[]{5, 4, 3, 2, 1}));

        System.out.println(optimal(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 5, 1}));
        System.out.println(optimal(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(optimal(new int[]{1, 2, 3, 4, 5}));
        System.out.println(optimal(new int[]{5, 4, 3, 2, 1}));
    }
    private static int bruteForce(int[] nums)
    {
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            if ((i == 0 || nums[i] > nums[i - 1]) &&  // check for left
                (i == n - 1 || nums[i] > nums[i + 1])) // check for right
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(n)
    // SC : O(1)

    private static int optimal(int[] nums)
    {
        int n = nums.length;

        if (n == 1)
        {
            return 0;
        }

        if (nums[0] > nums[1]) // first element is peak
        {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) // last element is peak
        {
            return n - 1;
        }

        int start = 1;
        int end = n - 2;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            {
                return mid;
            }
            else
            {
                if (nums[mid] < nums[mid + 1]) // move right
                {
                    start = mid + 1;
                }
                else // move left
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
