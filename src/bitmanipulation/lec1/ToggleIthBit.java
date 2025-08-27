package bitmanipulation.lec1;

public class ToggleIthBit
{
    public static void main(String[] args)
    {
        System.out.println(toggleIthBit(13, 2));
        System.out.println(toggleIthBit(10, 1));
        System.out.println(toggleIthBit(10, 0));
    }

    private static int toggleIthBit(int n, int i)
    {
        return n ^ (1 << i);
    }
    // TC : O(1)
    // SC : O(1)
}
