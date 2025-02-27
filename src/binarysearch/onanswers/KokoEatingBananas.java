package binarysearch.onanswers;

import java.util.stream.IntStream;

public class KokoEatingBananas
{
    public static void main(String[] args)
    {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(bruteForce(piles, h));

    }

    private static int bruteForce(int[] piles, int h)
    {
        int n = piles.length;
        int max = IntStream.of(piles).max().getAsInt();
        for (int i = 1; i <= max; i++)
        {
            int hours = 0;
            for (int j = 0; j < n; j++)
            {
                hours += Math.ceil((double) piles[j] / i);
            }
            if (hours <= h)
            {
                return i;
            }
        }
        return -1;
    }

}
