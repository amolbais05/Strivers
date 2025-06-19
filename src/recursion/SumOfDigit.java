package recursion;

public class SumOfDigit
{
    private static int sumOfDigit(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        return (n % 10) + sumOfDigit(n / 10);
    }
    // TC : O (log n)
    // SC : O (log n)



    private static int sumOfDigitIterative(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    // TC : O (log n)
    // SC : O (1)

    public static void main(String[] args)
    {
        System.out.println(sumOfDigit(1234));
    }
}
