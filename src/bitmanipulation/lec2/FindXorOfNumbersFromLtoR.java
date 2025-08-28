package bitmanipulation.lec2;

public class FindXorOfNumbersFromLtoR
{
    private int findXorBrute(int L, int R)
    {
        int xor = 0;
        for (int i = L; i <= R; i++)
        {
            xor ^= i;
        }
        return xor;
    }
    // TC : O(R - L)
    // SC : O(1)

    int findXorOptimal(int L, int R)
    {
        return optimal(R) ^ optimal(L - 1); // L -1 is important
    }

    private int optimal(int n)
    {
        if (n % 4 == 0)
        {
            return n;
        }
        else if (n % 4 == 1)
        {
            return 1;
        }
        else if (n % 4 == 2)
        {
            return n + 1;
        }
        else
        {
            return 0;
        }
        // TC : O(1)
        // SC : O(1)

    }
}
