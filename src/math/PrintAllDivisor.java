package math;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisor
{
    static int[] bruteForceApproach(int number, int[] size)
    {
        int allDivisor[] = new int[number];
        int count = 0;
        for (int divisor = 1; divisor <= number; divisor++)
        {
            if (number % divisor == 0)
            {
               allDivisor[count++] = divisor;
            }
        }
        size[0] = count;
        return allDivisor;
    } // TC, SC O(N)

    static List<Integer> optimalApproach(int number)
    {
        List<Integer> divisors = new ArrayList<>();
        int sqrtNumber = (int) Math.sqrt(number);

        for (int divisor = 1; divisor <= sqrtNumber ; divisor++)
        {
            if (sqrtNumber % divisor == 0)
            {
                divisors.add(divisor);

                if (number / divisor != divisor)
                {
                    divisors.add(number / divisor);
                }
            }
        }
        return divisors;
    } // TC : O(sqrt(N)) , SC :  O(2*sqrt(N))


    public static void main(String[] args)
    {
        int size[] = new int[1];
        int[] divisors = bruteForceApproach(35, size);
        for (int i = 0; i < size[0]; i++) {
            System.out.print(divisors[i] + " ");
        }
        System.out.println();
    }
}
