package bitmanipulation.lec1;

public class SetIthBit
{
    public static void main(String[] args)
    {
        System.out.println(setIthBit(9, 2));
        System.out.println(setIthBit(13, 2));
        System.out.println(setIthBit(10, 1));
        System.out.println(setIthBit(10, 0));
    }

    private static int setIthBit(int n, int i)
    {
        return n | (1 << i);
    }
    // TC : O(1)
    // SC : O(1)
}
