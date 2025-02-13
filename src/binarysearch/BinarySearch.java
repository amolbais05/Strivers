package binarysearch;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        System.out.println(iteratative(arr, target));
        System.out.println(recursive(arr, target, 0, arr.length - 1));
    }

    public static int iteratative(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                return mid;
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
        return -1;
    }
    //  TC : O(log n)
    //  SC : O(1)

    public static int recursive(int[] arr, int target, int low, int high)
    {
        if (low > high)
        {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target)
        {
            return mid;
        }
        else if (target > arr[mid])
        {
            return recursive(arr, target, mid + 1, high);
        }
        else
        {
            return recursive(arr, target, low, mid - 1);
        }
    }
    //  TC : O(log n)
    //  SC : O(log n)
}
