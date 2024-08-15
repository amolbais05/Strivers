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
        return IntStream.rangeClosed(1, num).sum();
    } // TC : O(n)



}
