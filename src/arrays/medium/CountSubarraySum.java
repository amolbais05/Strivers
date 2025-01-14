package arrays.medium;

public class CountSubarraySum
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(bruteForce(nums, k));
        System.out.println(better(nums, k));


    }

    private static int bruteForce(int[] nums, int target)
    {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                int sum = 0;
                for (int k = i; k <= j; k++)
                {
                    sum += nums[k];
                }
                if (sum == target)
                {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(N^3)
    // SC : O(1)

    private static int better(int[] nums, int target)
    {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += nums[j];

                if (sum == target)
                {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(N^2)
    // SC : O(1)

    private static int optimal(int[] nums, int target)
    {
        int n = nums.length;
        int count = 0;

        return count;
    }
}