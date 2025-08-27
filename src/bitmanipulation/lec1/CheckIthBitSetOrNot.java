package bitmanipulation.lec1;

public class CheckIthBitSetOrNot
{
    public static void main(String[] args)
    {
        System.out.println(checkIthBitSetOrNot(13, 2));
        System.out.println(checkIthBitSetOrNot(10, 3));
        System.out.println(checkIthBitSetOrNot(10, 2));
        System.out.println(checkIthBitSetOrNot(10, 1));
        System.out.println(checkIthBitSetOrNot(10, 0));
    }

    private static boolean checkIthBitSetOrNot(int n, int i)
    {
        return (n & (1 << i)) != 0;
    }

    private static boolean checkIthBitSetOrNotUsingRightShift(int n, int i)
    {
        return ((n >> i) & 1) == 1;
    }
    // TC : O(1)
    // SC : O(1)
}
