package bitmanipulation.lec1;

public class OddOrNot
{
    public static void main(String[] args)
    {
        System.out.println(isOdd(13));
        System.out.println(isOdd(12));
        System.out.println(isOdd(11));
        System.out.println(isOdd(10));
        System.out.println(isOdd(9));
        System.out.println(isOdd(8));
        System.out.println(isOdd(7));
        System.out.println(isOdd(6));
        System.out.println(isOdd(5));
        System.out.println(isOdd(4));
        System.out.println(isOdd(3));
        System.out.println(isOdd(2));
        System.out.println(isOdd(1));
        System.out.println(isOdd(0));
    }

    private static boolean isOdd(int n)
    {
        return (n & 1) == 1;
    }
    // TC : O(1)
    // SC : O(1)
    
    private static boolean isEven(int n)
    {
        return (n & 1) == 0;
    }
}
