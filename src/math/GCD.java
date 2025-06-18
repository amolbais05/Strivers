package math;

public class GCD
{
    public static int findGcd(int num1, int num2)
    {
        for (int i = Math.min(num1, num2); i >= 1; i--)
        {
            if (num1 % i == 0 && num2 % i == 0)
            {
                return i;
            }
        }
        return 1;
    }

    // Time Complexity: O(min(N1, N2))
    // Space Complexity: O(1)

    public static int findGcdRecursive(int num1, int num2)
    {
        if (num2 == 0)
        {
            return num1;
        }
        return findGcdRecursive(num2, num1 % num2);
    }
    // Time Complexity: O(log(min(N1, N2)))
    // Space Complexity: O(log(min(N1, N2)))

}
