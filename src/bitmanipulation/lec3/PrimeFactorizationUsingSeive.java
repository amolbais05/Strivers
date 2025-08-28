package bitmanipulation.lec3;

public class PrimeFactorizationUsingSeive
{

    private static void sieveOfEratosthenes(int n)
    {
        boolean[] isPrime = new boolean[n + 1];
        // Initialize all numbers as prime
        for (int i = 2; i < n; i++)
        {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++)
        {
            if (isPrime[i])
            {
                for (int j = i * i; j < n; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++)
        {
            if (isPrime[i])
            {
                System.out.print(i + " ");
                count++;
            }
        }

    }
}
