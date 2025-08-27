package bitmanipulation.lec1;

public class CountTheNumberOfSetBits
{
    public static void main(String[] args)
    {
        System.out.println(countTheNumberOfSetBits(13));
        System.out.println(countTheNumberOfSetBits(16));
        System.out.println(countTheNumberOfSetBits(1));

    }

    private static int countTheNumberOfSetBits(int n)
    {
        int count = 0;
        if (n <= 0)
        {
            return count;
        }
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                count++;
            }
            n = n / 2;
        }
        return count;
    }

    private static int countTheNumberOfSetBits2(int n)
    {
        int count = 0;
        while (n > 0)
        {
            // Check if last bit is 1
            if ((n & 1) == 1)
            {
                count++;
            }
            // Right shift by 1
            n = n >> 1;
        }
        return count;
    }

    private static int countTheNumberOfSetBits3(int n)
    {
        int count = 0;
        while (n > 0)
        {
            n = n & (n - 1);  // Drops the lowest set bit
            count++;
        }
        return count;
    }


}
