package recursion;

public class Fibonacci
{
    public static void main(String[] args)
    {
        printFibo(5);
    }
    private static void printFibo(int n)
    {
        if (n == 0)
        {
            System.out.println("0");
        }
        int fib[] = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i = 0; i < fib.length; i++)
        {
            System.out.print(fib[i] + " ");
        }

    }
    // TC : O (n)
    // SC : O (n)

    private static int fib(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    // TC : O (2^n) : because of bidirectional recursive call
    // SC : O (n)
}
