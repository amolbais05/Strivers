package math;

public class Prime
{

    static boolean bruteForce(int nummber)
    {
        int count = 0;
        for (int divisor = 1; divisor <= nummber; divisor++)
        {
            if (nummber % divisor == 0)
            {
                count ++;
            }
        }
        return count == 2;
    } // TC O(N), SC (1)

    static boolean optimalApproach(int number)
    {
        int count = 0;
        for (int divisor = 1; divisor <= Math.sqrt(number) ; divisor++)
        {
            if (number % divisor == 0)
            {
                count++;

                if (number / divisor != divisor)
                {
                    count++;
                }
            }
        }
        return count == 2;
    } // TC O(sqrt(N)), SC O(1)

    public static void main(String[] args)
    {
        System.out.println(optimalApproach(5));
    }
}
