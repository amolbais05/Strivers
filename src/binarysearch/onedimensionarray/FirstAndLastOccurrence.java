package binarysearch.onedimensionarray;

public class FirstAndLastOccurrence
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10};
        int target = 4;
        System.out.println(bruteForce(arr, target));
        System.out.println(optimal(arr, target));
    }
    private static int[] bruteForce(int[] nums, int target)
    {
        int ans[] = {-1,-1};

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==target)
            {
                ans[0]=i;
                break;
            }
        }
        for(int i=nums.length-1; i>=0; i--)
        {
            if(nums[i]==target)
            {
                ans[1]=i;
                break;
            }
        }
        return ans;

    }
    // TC : O(n)
    // SC : O(1)

    private static int[] optimal(int[] nums, int target)
    {
        int first = findPosition(nums, target, true);
        int last = findPosition(nums, target, false);

        return new int[] { first, last };
    }

    private static int findPosition(int[] nums, int target, boolean findFirst)
    {
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                pos = mid;
                if (findFirst)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return pos;
    }
    // TC : O(log n)
    // SC : O(1)
}
