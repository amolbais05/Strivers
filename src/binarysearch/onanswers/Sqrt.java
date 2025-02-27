package binarysearch.onanswers;

public class Sqrt
{
    public static void main(String[] args)
    {
        int n = 36;
        System.out.println(bruteForce(n));
        System.out.println(bruteForce2(n));
        System.out.println(better(n));
        System.out.println(optimal(n));
    }

    private static int bruteForce(int n)
    {
        int ans = 0;
        // linear search on the answer space
        for (long i = 1; i <= n; i++)
        {
            long val = i * i;
            if (val <= (long) n)
            {
                ans = (int) i;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
    // TC : O(sqrt(n))
    // SC : O(1)

    private static int bruteForce2(int n)
    {
        int ans = 0;
        // linear search on the answer space
        for (long i = 1; i <= n / 2; i++)
        {
            long val = i * i;
            if (val <= (long) n)
            {
                ans = (int) i;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
    // TC : O(sqrt(n))
    // SC : O(1)

    private static int better(int n)
    {
        return (int) Math.sqrt(n);
    }
    // TC : O(1)
    // SC : O(1)

    private static int optimal(int n)
    {
        int start = 1;
        int end = n;
        int ans = 0;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            long val = (long) mid * mid;
            if (val <= (long) n)
            {
                ans = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return ans;
    }
    // TC : O(log n)
    // SC : O(1)
}
