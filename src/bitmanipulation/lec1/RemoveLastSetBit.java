package bitmanipulation.lec1;

public class RemoveLastSetBit
{
    public static void main(String[] args)
    {
        System.out.println(removeLastSetBit(12));
        System.out.println(removeLastSetBit(13));
        System.out.println(removeLastSetBit(14));
        System.out.println(removeLastSetBit(15));
        System.out.println(removeLastSetBit(16));
        System.out.println(removeLastSetBit(17));
        System.out.println(removeLastSetBit(18));
        System.out.println(removeLastSetBit(19));
        System.out.println(removeLastSetBit(20));
    }

    private static int removeLastSetBit(int n)
    {
        return n & (n - 1);
    }
    // TC : O(1)
    // SC : O(1)
}
