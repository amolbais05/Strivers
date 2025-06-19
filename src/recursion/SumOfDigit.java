package recursion;

public class SumOfDigit
{
    public static int sumOfDigit(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        return (n % 10) + sumOfDigit(n / 10);
    }
    // TC : O (log n)
    // SC : O (log n)

    public static void main(String[] args)
    {
        System.out.println(sumOfDigit(1234));
    }
}
