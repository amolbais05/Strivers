package bitmanipulation.lec1;

public class ClearIthBit
{
    public static void main(String[] args)
    {
        System.out.println(clearIthBit(13, 2));
        System.out.println(clearIthBit(10, 0));
        System.out.println(clearIthBit(10, 1));
        System.out.println(clearIthBit(10, 3));
    }

    private static int clearIthBit(int n, int i)
    {
        return n & ~(1 << i);
    }
    // TC : O(1)
    // SC : O(1)
}
