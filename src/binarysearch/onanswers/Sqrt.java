package binarysearch.onanswers;

public class Sqrt
{
    public static void main(String[] args)
    {
        int n = 4;
        System.out.println(bruteForce(n));
        System.out.println(better(n));
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

    private static int better(int n)
    {
        return (int) Math.sqrt(n);
    }
    // TC : O(1)
    // SC : O(1)
}
