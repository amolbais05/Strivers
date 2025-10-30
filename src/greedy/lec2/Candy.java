package greedy.lec2;

import java.util.Arrays;

public class Candy
{
    private int candyApproach1(int[] ratings)
    {
        int n = ratings.length;
        int candy = 0;

        int[] l2r = new int[n];
        int[] r2l = new int[n];

        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);

        // Left to right
        for (int i = 1; i < n; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                l2r[i] = Math.max(l2r[i], l2r[i - 1] + 1);
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1])
            {
                r2l[i] = Math.max(r2l[i], r2l[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++)
        {
            candy += Math.max(l2r[i], r2l[i]);
        }
        return candy;
    }

    private int candyApproach1_inLessSpace(int[] ratings)
    {
        int n = ratings.length;
        int candy = 0;

        int[] count = new int[n];

        Arrays.fill(count, 1);

        // Left to right
        for (int i = 1; i < n; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                count[i] = Math.max(count[i], count[i - 1] + 1);
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1])
            {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++)
        {
            candy += count[i];
        }
        return candy;
    }

    private int candyApproach2(int[] ratings)
    {

        int n = ratings.length;
        int candy = n;

        int i = 1;

        while (i < n)
        {
            if (ratings[i] == ratings[i - 1])
            {
                i++;
                continue;
            }

            // Increasing slope
            int peak = 0;
            while (ratings[i] > ratings[i - 1])
            {
                peak++;
                candy += peak;
                i++;
                if (i == n)
                {
                    return candy;
                }
            }

            // Decreasing slope
            int dip = 0;
            while (i < n && ratings[i] < ratings[i - 1])
            {
                dip++;
                candy += dip;
                i++;
            }
            candy -= Math.min(peak, dip);
        }
        return candy;
    }

}
