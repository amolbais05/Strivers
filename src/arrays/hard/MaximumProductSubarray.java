package arrays.hard;

public class MaximumProductSubarray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, -3, 0, -4, -5};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[] arr)
    {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                int product = 1;
                for (int k = i; k <= j; k++)
                {
                    product *= arr[k];
                }
                max = Math.max(max, product);
            }
        }
        return max;
    }
    // TC : O(N^3)
    // SC : O(1)

    private static int better(int[] arr)
    {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            int product = 1;
            for (int j = i; j < n; j++)
            {
                product *= arr[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }
    // TC : O(N^2)
    // SC : O(1)

    private static int optimal(int[] arr)
    {
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            if (prefix == 0)
            {
                prefix = 1;
            }
            if (suffix == 0)
            {
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
    // TC : O(N)
    // SC : O(1)
}
