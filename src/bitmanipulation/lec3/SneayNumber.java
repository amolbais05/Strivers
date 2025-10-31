package bitmanipulation.lec3;

public class SneayNumber
{
    public int[] getSneakyNumbers(int[] nums)
    {
        int n = nums.length - 2;

        int XOR = 0;

        // XOR all numbers in the given array
        for (int num : nums)
        {
            XOR ^= num;
        }

        // XOR all numbers from 0 to n - 1 (original sequence)
        for (int i = 0; i < n; i++)
        {
            XOR ^= i;
        }

        // Find rightmost set bit (distinguish between the two numbers)
        int mask = XOR & -XOR;

        int G1 = 0;
        int G2 = 0;

        // Divide nums into two groups and XOR separately
        for (int num : nums)
        {
            if ((num & mask) != 0)
            {
                G1 ^= num;
            }
            else
            {
                G2 ^= num;
            }
        }

        // Do the same for 0..n-1
        for (int num = 0; num < n; num++)
        {
            if ((num & mask) != 0)
            {
                G1 ^= num;
            }
            else
            {
                G2 ^= num;
            }
        }

        return new int[] {G1, G2};
    }

}
