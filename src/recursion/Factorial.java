package recursion;

import java.util.stream.LongStream;

public class Factorial
{
    public static void main(String[] args)
    {
        System.out.println(itereative(5));
        System.out.println(recursive(5));
        System.out.println(factorial(5));
    }

    public static int itereative(int num)
    {
        int ans = 1;
        for (int i = 1; i <= num ; i++)
        {
            ans *= i;
        }
        return ans;
    }
    // TC : O (n)
    // SC : O (1)

    public static int recursive(int num)
    {
        // base case
        if (num == 0)
        {
            return 1;
        }
        return num * recursive(num -1);
    }
    // TC : O (n)
    // SC : O (n)

    public static Long factorial(int num)
    {
        if (num < 0)
        {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        return LongStream.rangeClosed(1, num)
            .reduce(1, (a, b) -> a * b);
    }
    // TC : O (n)
    // SC : O (1)

    public static Long tailRecursion(int num, int fact)
    {
        if (num <= 1)
        {
            return (long) fact;
        }
        return tailRecursion(num -1, num * fact);
    }
    // TC : O (n)
    // SC : O (n)
    // Call it like tailRecursion(5, 1)
}
