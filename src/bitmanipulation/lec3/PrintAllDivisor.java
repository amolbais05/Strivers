package bitmanipulation.lec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllDivisor
{
    public static void main(String[] args)
    {
        printAllDivisors(10);
    }

    public static void printAllDivisors(int n)
    {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                divisors.add(i);
                if (i != n / i)
                {
                    divisors.add(n / i);
                }
            }
        }

        // Sort to print in ascending order
        Collections.sort(divisors);
        System.out.println(divisors);
    }

    public static void printAllDivisorsOptimal(int n)
    {
        List<Integer> divisors = new ArrayList<>();

        // 1 is always a divisor
        divisors.add(1);

        // Check powers of 2 first using bit shifts
        int temp = n;
        int pow2 = 1;
        while ((temp & 1) == 0)
        { // while even
            pow2 <<= 1;          // multiply by 2
            divisors.add(pow2);
            temp >>= 1;          // divide by 2
        }

        // Now check odd divisors up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
            {
                divisors.add(i);
                if (i != n / i)
                {
                    divisors.add(n / i);
                }
            }
        }

        // Always include n itself
        if (!divisors.contains(n))
        {
            divisors.add(n);
        }

        // Sort result
        Collections.sort(divisors);
        System.out.println(divisors);
    }
}

