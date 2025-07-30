package recursion.lec1;

public class Pow
{
    public static void main(String[] args)
    {
        System.out.println(myPow(2, 10));
    }

    private static double myPow(double x, int n)
    {
        if (n == 0)
        {
            return 1;
        }
        if (x == 1)
        {
            return 1;
        }

        long N = n; // Use long to handle Integer.MIN_VALUE
        if (N < 0)
        {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private static double power(double x, long n)
    {
        double half = power(x, n / 2);
        if (n % 2 == 0)
        {
            return half * half;
        }
        else
        {
            return x * half * half;
        }
    }
}
// TC = O(log n)
// SC = O(log n)
