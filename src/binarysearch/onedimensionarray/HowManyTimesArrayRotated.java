package binarysearch.onedimensionarray;

public class HowManyTimesArrayRotated
{
    public static void main(String[] args)
    {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[] nums)
    {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++)
        {
            if (nums[i] < min)
            {
                min = nums[i];
                index = i;
            }
        }
        return index;
    }

    private static int optimal(int[] nums)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            // if array is not rotated
            if (nums[start] <= nums[end])
            {
                if (nums[start] < min)
                {
                    index = start;
                    min = nums[start];
                }
                break;
            }

            if (nums[start] <= nums[mid])
            {
                if (nums[start] < min)
                {
                  index = start;
                  min = nums[start];
                }

                start = mid + 1;
            }
            else
            {
                if (nums[mid] < min)
                {
                    index = mid;
                    min = nums[mid];
                }
                end = mid - 1;
            }
        }
        return index;
    }
}
