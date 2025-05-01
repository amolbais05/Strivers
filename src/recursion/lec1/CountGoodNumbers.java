package recursion.lec1;

public class CountGoodNumbers
{
    long M = 1000000007L;

    public int countGoodNumbers(long n)
    {

        long mod = M;
        long part1 = findPower(5, (n + 1) / 2);
        long part2 = findPower(4, n / 2);
        return (int)((part1 * part2) % mod);

    }

    private long findPower(long a, long b)
    {
        if (b == 0)
        {
            return 1;
        }

        long half = findPower(a, b/2);
        long result = half * half % M;

        if (b % 2 == 1)
        {
            result = (result * a) % M;
        }
        return result;
    }
    // SC : O Log (N)
    // TC : O Log (N)
}
