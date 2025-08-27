package bitmanipulation.lec2;

public class MinimumBitFlip
{
    public static void main(String[] args)
    {
        System.out.println(minimumBitFlip(10, 7));
        System.out.println(minimumBitFlip(10, 13));
        System.out.println(minimumBitFlip(10, 10));
    }

    private static int minimumBitFlip(int a, int b)
    {
        int n = a ^ b;

        return numberOfSetBit(n);

    }

    private static int numberOfSetBit(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if ((n & 1) == 1)
            {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}