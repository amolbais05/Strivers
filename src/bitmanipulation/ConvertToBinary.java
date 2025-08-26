package bitmanipulation;

public class ConvertToBinary
{
    public static void main(String[] args)
    {
        System.out.println(convertToBinary(1));
        System.out.println(convertToBinary(2));
        System.out.println(convertToBinary(3));
        System.out.println(convertToBinary(4));
        System.out.println(convertToBinary(5));
        System.out.println(convertToBinary(9));
        System.out.println(convertToBinary(12));
        System.out.println(convertToBinary(13));
        System.out.println(convertToBinary(16));
    }

    private static String convertToBinary(int n)
    {
        if (n == 0)
        {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (n > 0)
        {
            res.append((n % 2 == 1) ? "1" : "0");
            n = n / 2;
        }
        return res.reverse().toString();
    }
    // TC : O(log n)
    // SC : O(1)

    private static String convertToBinaryOptimized(int n)
    {
        if (n == 0)
        {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (n > 0)
        {
            res.append((n & 1) == 1 ? "1" : "0"); // check last bit
            n >>= 1; // right shift
        }
        return res.reverse().toString();
    }

}