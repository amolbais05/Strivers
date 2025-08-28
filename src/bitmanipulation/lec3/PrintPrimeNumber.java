package bitmanipulation.lec3;

public class PrintPrimeNumber
{
    public static void printPrimeFactors(int n)
    {
        if (n <= 1)
        {
            System.out.println("No prime factors for " + n);
            return;
        }

        // Step 1: Print the factor 2 while divisible
        while (n % 2 == 0)
        {
            System.out.print(2 + " ");
            n /= 2;
        }

        // Step 2: Print odd factors
        for (int i = 3; i * i <= n; i += 2)
        {
            while (n % i == 0)
            {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // Step 3: If n is still > 2, then n itself is a prime
        if (n > 2)
        {
            System.out.print(n);
        }
    }
    // TC : O(sqrt(n))
    // SC : O(1)

    public static void printPrimeFactorsOptimal(int n)
    {
        if (n <= 1)
        {
            System.out.println("No prime factors for " + n);
            return;
        }

        // Factor out powers of 2 using bit manipulation
        while ((n & 1) == 0)
        {   // (n % 2 == 0) ? use bitwise check
            System.out.print(2 + " ");
            n >>= 1;             // n = n / 2
        }

        // Check odd numbers (only odds left since evens are removed)
        for (int i = 3; i * i <= n; i += 2)
        {
            while (n % i == 0)
            {
                System.out.print(i + " ");
                n /= i; // still need division here
            }
        }

        // If n > 2 ? prime
        if (n > 2)
        {
            System.out.print(n);
        }
    }
}
