package arrays.medium;

public class MaximumSubarray
{
    public static void main(String[] args)
    {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
    private static int bruteForce(int arr[])
    {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    // TC : O(N^2)
    // SC : O(1)

    // Kadane's Algorithm
    private static int better(int arr[])
    {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }
    // TC : O(N)
    // SC : O(1)


    private static int optimal(int arr[])
    {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }
}
