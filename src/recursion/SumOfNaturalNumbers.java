package recursion;

import java.util.stream.IntStream;

public class SumOfNaturalNumbers
{
    public static void main(String[] args)
    {
        System.out.println(naiveApproach(10));
        System.out.println(optimalApproach(10));
        recursiveParameterizedApproach(10, 0);
        System.out.println(recursiveFunctionalApproach(10));
        System.out.println(javaStream(10));

    }

    private static int recursiveFunctionalApproach(int num)
    {
        if (num == 0)
        {
            return 0;
        }
        return num + recursiveFunctionalApproach(num - 1);
    }
    // TC : O (n)
    // SC : O (n)

    private static void recursiveParameterizedApproach(int num, int sum)
    {
        if (num < 0)
        {
            System.out.println(sum);
            return;
        }
        recursiveParameterizedApproach(num - 1, sum + num);
    }
    // TC : O (n)
    // SC : O (n)

    private static int optimalApproach(int num)
    {
        return num * (num + 1) / 2;
    } // TC : O (1)

    private static int naiveApproach(int num)
    {
        int sum = 0;
        for (int i = 0; i <= num; i++)
        {
            sum += i;
        }
        return sum;
    } // TC : O(n)

    private static int javaStream(int num)
    {
        return IntStream.rangeClosed(1, num).sum();
    } // TC : O(1)



}
