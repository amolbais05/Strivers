package bitmanipulation.lec1;

public class DivideTwoIntegers
{
    public static void main(String[] args)
    {
        System.out.println(divideTwoIntegers(22, 3));
    }


    private static int divideTwoIntegers(int dividend, int divisor)
    {
        int sum = 0;
        int count = 0;
        while (sum <= dividend)
        {
            sum += divisor;
            count++;
        }
        return count - 1;
    }
    // TC : O(n)
    // SC : O(1)

    private static int divideTwoIntegersOptimized(int dividend, int divisor)
    {
        int count = 0;
        while (dividend >= divisor)
        {
            dividend -= divisor;
            count++;
        }
        return count;
    }

    private static int divideTwoIntegersOptimized2(int dividend, int divisor)
    {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
        {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor)
        {
            return 1;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long dividendLong = Math.abs(dividend);
        long divisorLong = Math.abs(divisor);

        int result = 0;
        long quotient = 0;
        while (dividendLong >= divisorLong)
        {
            int count = 0;

            // Find the largest shift where (divisorLong << count) fits in dividendLong
            while (dividendLong >= (divisorLong << (count + 1)))
            {
                count++;
            }

            // Add the power of 2 to quotient
            quotient += 1L << count;

            // Subtract the shifted divisor from dividend
            dividendLong -= divisorLong << count;
        }
        return (int) (isNegative ? quotient : -quotient);
    }

}
